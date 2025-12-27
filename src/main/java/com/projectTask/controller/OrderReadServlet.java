package com.projectTask.controller;

import com.google.gson.Gson;
import com.projectTask.model.CustomerDetailsModel;
import com.projectTask.model.ProductRelatedModel;
import com.projectTask.service.OrderReadService;
import com.projectTask.service.OrderReadServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/OrdersReads")
public class OrderReadServlet extends HttpServlet {

    private final OrderReadService service = new OrderReadServiceImpl();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
    	Map<CustomerDetailsModel, List<ProductRelatedModel>> fetchOrderDetails=null;
        res.setContentType("application/json");
        fetchOrderDetails = service.fetchOrderDetails();
        
        if (fetchOrderDetails == null || fetchOrderDetails.isEmpty()) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            res.getWriter().write("{\"message\":\"No order data found\"}");
        } else {
            res.setStatus(HttpServletResponse.SC_OK);
            res.getWriter().write(gson.toJson(fetchOrderDetails)
            );
        }
    }
}
