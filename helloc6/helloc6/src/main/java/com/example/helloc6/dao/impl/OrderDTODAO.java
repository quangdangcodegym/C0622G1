package com.example.helloc6.dao.impl;

import com.example.helloc6.dao.DatabaseQuery;
import com.example.helloc6.dao.IOrderDAO;
import com.example.helloc6.dao.IOrderDTODAO;
import com.example.helloc6.dao.IOrderItemDTODAO;
import com.example.helloc6.model.Order;
import com.example.helloc6.model.dto.OrderDTO;
import com.example.helloc6.model.dto.OrderItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDTODAO extends DatabaseQuery implements IOrderDTODAO {
    private IOrderDAO iOrderDAO;
    private IOrderItemDTODAO iOrderItemDTODAO;

    public OrderDTODAO() {
        this.iOrderDAO = new OrderDAO();
        this.iOrderItemDTODAO = new OrderItemDTODAO();
    }
    @Override
    public void insertOrderDTO(OrderDTO orderDTO) throws SQLException {

    }

    @Override
    public OrderDTO selectOrderDTO(int id) throws SQLException {
        List<OrderDTO> orderDTOList = selectAllOrderDTO();
        for (OrderDTO orderDTO : orderDTOList) {
            if(orderDTO.getId() == id){
                return orderDTO;
            }
        }
        return null;
    }

    @Override
    public List<OrderDTO> selectAllOrderDTO() throws SQLException {
        List<Order> orderList = iOrderDAO.selectAllOrders();
        List<OrderDTO> orderDTOList = new ArrayList<>();

        for(Order order : orderList){
            List<OrderItemDTO> orderItemList = iOrderItemDTODAO.selectAllOrderItemDTOByOrderId(order.getId());
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderToOrderDTO(order);
            orderDTO.setOrderItemList(orderItemList);

            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }

    @Override
    public boolean deleteOrderDTO(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateOrderDTO(OrderDTO orderDTO) throws SQLException {
        return false;
    }

    @Override
    public boolean updateOrderDTOWithSP(OrderDTO orderDTO) throws SQLException {
        return false;
    }

    @Override
    public boolean checkEmailExists(String email) throws SQLException {
        return false;
    }
}
