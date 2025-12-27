package com.projectTask.service;

import com.projectTask.dao.CustomerDao;
import com.projectTask.dao.CustomerDaoImpl;
import com.projectTask.model.Customer;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao dao = new CustomerDaoImpl();

    @Override
    public Customer createCustomer(Customer customer) {
        return dao.createCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return dao.getCustomerById(customerId);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return dao.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        return dao.deleteCustomer(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return dao.getAllCustomers();
    }
}

