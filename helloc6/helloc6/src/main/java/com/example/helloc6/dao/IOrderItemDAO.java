package com.example.helloc6.dao;

import com.example.helloc6.model.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface IOrderItemDAO {
    public void insertOrderItem(OrderItem orderItem) throws SQLException;

    public OrderItem selectOrderItem(int id) throws SQLException;

    public List<OrderItem> selectAllOrderItem() throws SQLException;

    public List<OrderItem> selectAllOrderItemFromOrderID(int idOrder) throws SQLException;


    public boolean deleteOrderItem(int id) throws SQLException;

    public boolean updateOrderItem(OrderItem orderItem) throws SQLException;

    public boolean updateOrderItemWithSP(OrderItem orderItem) throws SQLException;

    public boolean checkEmailExists(String email) throws SQLException;
}
