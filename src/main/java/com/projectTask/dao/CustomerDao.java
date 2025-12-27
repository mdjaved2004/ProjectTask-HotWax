package com.projectTask.dao;

import com.projectTask.model.Customer;
import java.util.List;

public interface CustomerDao {
	Customer createCustomer(Customer customer);
    Customer getCustomerById(int customerId);
    Customer updateCustomer(Customer customer);
    boolean deleteCustomer(int customerId);
    List<Customer> getAllCustomers();
}
    
