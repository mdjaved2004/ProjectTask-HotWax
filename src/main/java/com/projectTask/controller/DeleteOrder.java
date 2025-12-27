package com.projectTask.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.projectTask.service.DeleteOrderServiceImpl;

@WebServlet("/DeleteOrder")
public class DeleteOrder extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        int orderId = -1;

        try {
           
            String param = req.getParameter("orderId");

            if (param != null && !param.isEmpty()) {
                orderId = Integer.parseInt(param);
            } 
            
            else {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = req.getReader().readLine()) != null) {
                    sb.append(line);
                }

                if (sb.length() > 0) {
                    JSONObject json = new JSONObject(sb.toString());
                    orderId = json.getInt("orderId");
                }
            }

            
            if (orderId <= 0) {
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                res.getWriter().write("{\"error\":\"Invalid orderId\"}");
                return;
            }

            // Service call
            String message = new DeleteOrderServiceImpl().deleteOrder(orderId);

            if (message.toLowerCase().contains("error") ||
                message.toLowerCase().contains("failed")) {

                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                res.getWriter().write("{\"error\":\"" + message + "\"}");

            } else {
                res.setStatus(HttpServletResponse.SC_OK);
                res.getWriter().write("{\"message\":\"" + message + "\"}");
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            res.getWriter().write("{\"error\":\"Something went wrong\"}");
        }
    }
}
