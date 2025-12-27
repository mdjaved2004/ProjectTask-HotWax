package com.projectTask.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.projectTask.model.Customer;
import com.projectTask.service.CustomerService;
import com.projectTask.service.CustomerServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/customers")
public class CustomerServlet extends HttpServlet {
    
	private final CustomerService service = new CustomerServiceImpl();
    private final Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("application/json");
        BufferedReader reader = req.getReader();
        Customer customer = gson.fromJson(reader, Customer.class);
        Customer created = service.createCustomer(customer);
        res.setStatus(HttpServletResponse.SC_CREATED);
        res.getWriter().write(gson.toJson(created));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("application/json");
        String idParam = req.getParameter("id");

        if (idParam != null) {
            int customerId = Integer.parseInt(idParam);
            Customer customer = service.getCustomerById(customerId);
            if (customer != null) {
                res.setStatus(HttpServletResponse.SC_OK);
                res.getWriter().write(gson.toJson(customer));
            } else {
                res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                res.getWriter().write("{\"error\":\"Customer not found\"}");
            }
        } else {
            List<Customer> list = service.getAllCustomers();
            res.setStatus(HttpServletResponse.SC_OK);
            res.getWriter().write(gson.toJson(list));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("application/json");
        Customer customer = gson.fromJson(req.getReader(), Customer.class);
        Customer updated = service.updateCustomer(customer);
        res.setStatus(HttpServletResponse.SC_OK);
        res.getWriter().write(gson.toJson(updated));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        try {
            //Read JSON body
            BufferedReader reader = req.getReader();
            JsonObject json = gson.fromJson(reader, JsonObject.class);

            int customerId = json.get("id").getAsInt();

            boolean deleted = service.deleteCustomer(customerId);

            if (deleted) {
                res.setStatus(HttpServletResponse.SC_OK);
                res.getWriter().write("{\"message\":\"Customer deleted successfully\"}");
            } else {
                res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                res.getWriter().write("{\"error\":\"Customer not found\"}");
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            res.getWriter().write("{\"error\":\"Invalid request data\"}");
        }
    }
}
