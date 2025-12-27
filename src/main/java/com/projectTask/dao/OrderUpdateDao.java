package com.projectTask.dao;

public interface OrderUpdateDao {
    boolean updateCustomerId(int orderId, int customerId);
}
