package com.projectTask.dao;

import com.projectTask.model.OrderHeader;
import com.projectTask.model.OrderInsertMessage;

public interface OrderDao {
	OrderInsertMessage createOrder(OrderHeader order);
}
