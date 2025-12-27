package com.projectTask.service;

import com.projectTask.dao.OrderUpdateDao;
import com.projectTask.dao.OrderUpdateDaoImpl;

public class OrderUpdateServiceImpl implements OrderUpdateService {

    private OrderUpdateDao dao = new OrderUpdateDaoImpl();

    @Override
    public String updateCustomerId(int orderId, int customerId) {

        boolean updated = dao.updateCustomerId(orderId, customerId);

        if (updated) {
            return "Order updated successfully";
        } else {
            return "Order not found";
        }
    }
}
