package com.projectTask.service;

import com.projectTask.model.CustomerDetailsModel;
import com.projectTask.model.ProductRelatedModel;

import java.util.List;
import java.util.Map;

public interface OrderReadService {
    Map<CustomerDetailsModel, List<ProductRelatedModel>> fetchOrderDetails();
}