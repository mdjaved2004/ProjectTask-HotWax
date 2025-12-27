package com.projectTask.dao;

import java.util.List;
import java.util.Map;

import com.projectTask.model.CustomerDetailsModel;
import com.projectTask.model.ProductRelatedModel;

public interface OrderReadDao {
    Map<CustomerDetailsModel, List<ProductRelatedModel>> getOrderDetails();
}