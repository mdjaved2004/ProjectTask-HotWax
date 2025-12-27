package com.projectTask.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderUpdateDaoImpl implements OrderUpdateDao {

    @Override
    public boolean updateCustomerId(int orderId, int customerId) {

        String sql = "UPDATE order_header SET customer_id=? WHERE order_id=?";

        try (Connection con = new ConnectionFactoryImpl().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, customerId);
            ps.setInt(2, orderId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
