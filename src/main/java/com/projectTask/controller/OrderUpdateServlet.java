package com.projectTask.controller;

import com.google.gson.Gson;
import com.projectTask.model.OrderUpdateRequestModel;
import com.projectTask.service.OrderUpdateService;
import com.projectTask.service.OrderUpdateServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/UpdateOrder")
public class OrderUpdateServlet extends HttpServlet {

    private final OrderUpdateService service = new OrderUpdateServiceImpl();
    private final Gson gson = new Gson();

    
    protected void doPut(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        try {
            OrderUpdateRequestModel body =
                    gson.fromJson(req.getReader(), OrderUpdateRequestModel.class);

            int orderId = body.getOrderId();
            int customerId = body.getCustomerId();

            String message = service.updateCustomerId(orderId, customerId);

            if ("Order updated successfully".equals(message)) {
                res.setStatus(HttpServletResponse.SC_OK);
                res.getWriter().write("{\"message\":\"" + message + "\"}");
            } else {
                res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                res.getWriter().write("{\"error\":\"" + message + "\"}");
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            res.getWriter().write("{\"error\":\"Invalid request\"}");
        }
    }
}