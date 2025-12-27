package com.projectTask.service;

import com.projectTask.dao.DeleteOrderDaoImpl;

public class DeleteOrderServiceImpl implements DeleteOrderService{

	public String deleteOrder(int orderId) throws Exception {
        return new DeleteOrderDaoImpl().deleteOrder(orderId);
        
    }

}
