package com.projectTask.dao;

import com.projectTask.model.CustomerDetailsModel;
import com.projectTask.model.ProductRelatedModel;

import java.sql.*;
import java.util.*;

public class OrderReadDaoImpl implements OrderReadDao {

    @Override
    public Map<CustomerDetailsModel, List<ProductRelatedModel>> getOrderDetails() {

        Map<CustomerDetailsModel, List<ProductRelatedModel>> map = new HashMap<>();

        String customerQuery =
            "SELECT DISTINCT c.customer_id, c.first_name, c.last_name, " +
            "oh.order_id, oh.order_date " +
            "FROM customer c " +
            "JOIN order_header oh ON c.customer_id = oh.customer_id";

        String productQuery =
            "SELECT oh.customer_id, oh.order_id, p.product_id, p.product_name, " +
            "oi.quantity, oi.status " +
            "FROM order_header oh " +
            "JOIN order_item oi ON oh.order_id = oi.order_id " +
            "JOIN product p ON oi.product_id = p.product_id";

        try (Connection con = new ConnectionFactoryImpl().getConnection()) {
            PreparedStatement psCustomer = con.prepareStatement(customerQuery);
            ResultSet rsCustomer = psCustomer.executeQuery();

            while (rsCustomer.next()) {
            		CustomerDetailsModel customer =
            		    new CustomerDetailsModel(
            		        rsCustomer.getInt("customer_id"),
            		        rsCustomer.getString("first_name"),
            		        rsCustomer.getString("last_name"),
            		        rsCustomer.getInt("order_id"),
            		        rsCustomer.getDate("order_date").toLocalDate()
            		    );
                map.putIfAbsent(customer, new ArrayList<>());
            }

            PreparedStatement psProduct = con.prepareStatement(productQuery);
            ResultSet rsProduct = psProduct.executeQuery();

            while (rsProduct.next()) {

            	ProductRelatedModel product = new ProductRelatedModel(
            	        rsProduct.getInt("product_id"),
            	        rsProduct.getString("product_name"),
            	        rsProduct.getInt("quantity"),
            	        rsProduct.getString("status")
            	);

                int custId = rsProduct.getInt("customer_id");
                int ordId = rsProduct.getInt("order_id");

                for (CustomerDetailsModel key : map.keySet()) {
                    if (key.getCustomerId() == custId &&
                        key.getOrderId() == ordId) {
                        map.get(key).add(product);
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}
