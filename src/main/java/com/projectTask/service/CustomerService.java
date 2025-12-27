package com.projectTask.service;

import java.util.List;

import com.projectTask.model.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(int customerId);
    Customer updateCustomer(Customer customer);
    boolean deleteCustomer(int customerId);
    List<Customer> getAllCustomers();
}
