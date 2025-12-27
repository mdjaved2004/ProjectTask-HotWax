package com.projectTask.service;

import com.projectTask.dao.*;
import com.projectTask.model.OrderHeader;
import com.projectTask.model.OrderInsertMessage;

public class OrderServiceImpl implements OrderService {

    private OrderDao dao = new OrderDaoImpl();

    public OrderInsertMessage createOrder(OrderHeader order){
        return dao.createOrder(order);
    }
}
