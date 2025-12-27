package com.projectTask.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteOrderDaoImpl implements DeleteOrderDao {

    @Override
    public String deleteOrder(int orderId) {
        String deleteQueryInOrderItemTable = "DELETE FROM Order_Item WHERE order_id=?";
        String deleteQueryInOrderHeader = "DELETE FROM Order_Header WHERE order_id=?";
        
        try (Connection con = new ConnectionFactoryImpl().getConnection();
             PreparedStatement psItem = con.prepareStatement(deleteQueryInOrderItemTable);
             PreparedStatement psHeader = con.prepareStatement(deleteQueryInOrderHeader)) {

            con.setAutoCommit(false);

            psItem.setInt(1, orderId);
            int rowsAffectedItem = psItem.executeUpdate();

            if (rowsAffectedItem > 0) {
                
                psHeader.setInt(1, orderId);
                int rowsAffectedHeader = psHeader.executeUpdate();

                if (rowsAffectedHeader > 0) {
                    con.commit(); // Commit transaction
                    return "Order deleted successfully";
                } else {
                    con.rollback(); 
                    return "Failed to delete order header. Transaction rolled back.";
                }

            } else {
                con.rollback();
                return "No order items found. Transaction rolled back.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error while deleting order: " + e.getMessage();
        }
    }
}
