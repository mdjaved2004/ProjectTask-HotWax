package com.projectTask.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.projectTask.model.OrderHeader;
import com.projectTask.model.OrderInsertMessage;
import com.projectTask.model.OrderItem;


public class OrderDaoImpl implements OrderDao {

    @Override
    public OrderInsertMessage createOrder(OrderHeader order){
        int orderId;
		try {
			Connection con =new ConnectionFactoryImpl().getConnection();
			
			String  orderQuery="INSERT INTO Order_Header(order_date,customer_id," +
			        "shipping_contact_mech_id,billing_contact_mech_id) VALUES(?,?,?,?)";
			      
			PreparedStatement ps = con.prepareStatement(orderQuery,Statement.RETURN_GENERATED_KEYS
			    );

			ps.setDate(1, new java.sql.Date(order.getOrderDate().getTime()));
			ps.setInt(2, order.getCustomerId());
			ps.setInt(3, order.getShippingContactMechId());
			ps.setInt(4, order.getBillingContactMechId());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			orderId = rs.getInt(1);

			for (OrderItem item : order.getOrderItems()) {
			    PreparedStatement ips = con.prepareStatement(
			        "INSERT INTO Order_Item(order_id,product_id,quantity,status)" +
			        " VALUES(?,?,?,?)");
			    ips.setInt(1, orderId);
			    ips.setInt(2, item.getProductId());
			    ips.setInt(3, item.getQuantity());
			    ips.setString(4, item.getStatus());
			    ips.executeUpdate();
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			return new OrderInsertMessage(-1, "Error for creating order");
		}
        return new OrderInsertMessage(orderId, null);
    }
}
