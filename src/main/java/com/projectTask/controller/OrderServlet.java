package com.projectTask.controller;

import com.google.gson.Gson;
import com.projectTask.model.OrderHeader;
import com.projectTask.model.OrderInsertMessage;
import com.projectTask.service.OrderService;
import com.projectTask.service.OrderServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
    private final Gson gson = new Gson();

    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            BufferedReader reader = req.getReader();
            OrderHeader order = gson.fromJson(reader, OrderHeader.class);
            OrderService orderService = new OrderServiceImpl();
            
            OrderInsertMessage orderModel = orderService.createOrder(order);
            if (orderModel.getErrorMessage() != null) {
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                res.getWriter().write(
                        "{\"error\":\"" + orderModel.getErrorMessage() + "\"}"
                );
            }else {       	
            	res.setContentType("application/json");
            	res.setStatus(HttpServletResponse.SC_CREATED);
            	res.getWriter().print(
            			"{\"message\":\"Order Created\",\"orderId\":" + orderModel.getOrderId() + "}");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
