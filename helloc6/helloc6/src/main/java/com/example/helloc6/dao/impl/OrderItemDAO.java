package com.example.helloc6.dao.impl;

import com.example.helloc6.dao.DatabaseQuery;
import com.example.helloc6.dao.IOrderItemDAO;
import com.example.helloc6.model.OrderItem;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDAO extends DatabaseQuery implements IOrderItemDAO {
    private static final String SELECT_ALL_ORDERITEM_BY_ORDERID = "SELECT id, orderid, productid, quantity, price " +
            "FROM orderitem where orderid = ?;";
    private static final String SELECT_ORDERITEM_BYID = "SELECT id, orderid, productid, quantity, price " +
            "FROM orderitem where id = ?;";

    @Override
    public void insertOrderItem(OrderItem orderItem) throws SQLException {

    }

    @Override
    public OrderItem selectOrderItem(int id) throws SQLException {
        try{
            Connection connection = getConnection();
            PreparedStatement preparableStatement = connection.prepareStatement(SELECT_ORDERITEM_BYID);
            preparableStatement.setInt(1 , id);

            ResultSet rs = preparableStatement.executeQuery();

            System.out.println(this.getClass() + " selectUser: " + preparableStatement);
            while (rs.next()){
                OrderItem orderItem = getOrderItemFromResultSet(rs);
                return orderItem;
            }
            connection.close();
        }catch (SQLException ex){
            printSQLException(ex);
        }
        return null;
    }

    @Override
    public List<OrderItem> selectAllOrderItem() throws SQLException {
        return null;
    }

    @Override
    public List<OrderItem> selectAllOrderItemFromOrderID(int idOrder) throws SQLException {
        List<OrderItem> listOrderItem = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparableStatement = connection.prepareStatement(SELECT_ALL_ORDERITEM_BY_ORDERID);
            preparableStatement.setInt(1, idOrder);
            ResultSet rs = preparableStatement.executeQuery();

            while (rs.next()){
                //SELECT id, orderid, productid, quantity, price FROM orderitem where orderid = 1;
                OrderItem orderItem = getOrderItemFromResultSet(rs);
                listOrderItem.add(orderItem);
            }
            connection.close();
        }catch (SQLException ex){
            printSQLException(ex);
        }
        return listOrderItem;
    }

    private OrderItem getOrderItemFromResultSet(ResultSet rs) throws SQLException{
        int id = rs.getInt("id");
        int idOrder = rs.getInt("orderid");
        int quantity = rs.getInt("quantity");
        int idProduct = rs.getInt("productid");
        BigDecimal price =rs.getBigDecimal("price");

        OrderItem orderItem = new OrderItem(id, idOrder, idProduct,quantity, price);
        return orderItem;

    }

    @Override
    public boolean deleteOrderItem(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateOrderItem(OrderItem orderItem) throws SQLException {
        return false;
    }

    @Override
    public boolean updateOrderItemWithSP(OrderItem orderItem) throws SQLException {
        return false;
    }

    @Override
    public boolean checkEmailExists(String email) throws SQLException {
        return false;
    }
}
