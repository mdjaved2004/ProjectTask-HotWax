package com.projectTask.service;

import com.projectTask.model.OrderHeader;
import com.projectTask.model.OrderInsertMessage;

public interface OrderService {
	OrderInsertMessage createOrder(OrderHeader order);
}
