package com.example.helloc6.dao.impl;

import com.example.helloc6.dao.DatabaseQuery;
import com.example.helloc6.dao.IProductDAO;
import com.example.helloc6.model.Product;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDAO extends DatabaseQuery implements IProductDAO {
    private static final String SELECT_ALL_PRODUCT = "SELECT id, name, price, createAt, updateAt, description FROM product;";
    private static final String SELECT_PRODUCT = "SELECT id, name, price, createAt, updateAt, description FROM product where id = ?";

    @Override
    public void insertProduct(Product Product) throws SQLException {

    }

    @Override
    public Product selectProduct(int id) {
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Product product = getProductFromResultSet(rs);
                return product;
            }
            connection.close();
        }catch (SQLException ex){
            printSQLException(ex);
        }
        return null;
    }

    @Override
    public List<Product> selectAllProducts() {
        List<Product> listProduct = new ArrayList<>();
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet rs = preparedStatement.executeQuery();
            //SELECT id, name, price, createAt, updateAt, description FROM product;
            System.out.println(this.getClass() + " selectAllProduct " + preparedStatement);
            while (rs.next()){
                Product product = getProductFromResultSet(rs);
                listProduct.add(product);
            }
            connection.close();
        }catch (SQLException ex){
            printSQLException(ex);
        }

        return listProduct;
    }

    private Product getProductFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        BigDecimal price = rs.getBigDecimal("price");
        java.sql.Date sql_CreateAt = rs.getDate("createAt");
        java.sql.Date sql_UpdateAt = rs.getDate("updateAt");
        String description = rs.getString("description");

        Date createAt = null;
        Date updateAt = null;
        if(sql_CreateAt!=null){
            createAt = new Date(sql_CreateAt.getTime());
        }
        if(sql_UpdateAt!=null){
            updateAt = new Date(sql_UpdateAt.getTime());
        }
        Product product = new Product(id, name,price, createAt , updateAt, description);
        return product;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateProduct(Product Product) throws SQLException {
        return false;
    }

    @Override
    public boolean updateProductWithSP(Product Product) throws SQLException {
        return false;
    }

    @Override
    public boolean checkEmailExists(String email) throws SQLException {
        return false;
    }
}
