package com.projectTask.dao;

import com.projectTask.model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public Customer createCustomer(Customer customer) {
        String query = "INSERT INTO customer(first_name, last_name) VALUES(?, ?)";
        try (Connection con = new ConnectionFactoryImpl().getConnection();
             PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                customer.setCustomerId(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        String query = "SELECT * FROM customer WHERE customer_id=?";
        Customer customer = null;
        try (Connection con = new ConnectionFactoryImpl().getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer(rs.getInt("customer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        String query = "UPDATE customer SET first_name=?, last_name=? WHERE customer_id=?";
        try (Connection con = new ConnectionFactoryImpl().getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setInt(3, customer.getCustomerId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        String query = "DELETE FROM customer WHERE customer_id=?";
        try (Connection con = new ConnectionFactoryImpl().getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, customerId);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        String query = "SELECT * FROM customer";
        try (Connection con = new ConnectionFactoryImpl().getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                list.add(new Customer(rs.getInt("customer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
