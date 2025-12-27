package com.projectTask.service;

import com.projectTask.dao.OrderReadDao;
import com.projectTask.dao.OrderReadDaoImpl;
import com.projectTask.model.CustomerDetailsModel;
import com.projectTask.model.ProductRelatedModel;

import java.util.List;
import java.util.Map;

public class OrderReadServiceImpl implements OrderReadService {

    private final OrderReadDao dao = new OrderReadDaoImpl();

    @Override
    public Map<CustomerDetailsModel, List<ProductRelatedModel>> fetchOrderDetails() {
        return dao.getOrderDetails();
    }
}
