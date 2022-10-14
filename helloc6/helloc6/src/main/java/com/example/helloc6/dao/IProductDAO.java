package com.example.helloc6.dao;

import com.example.helloc6.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public void insertProduct(Product Product) throws SQLException;

    public Product selectProduct(int id);

    public List<Product> selectAllProducts();

    public boolean deleteProduct(int id) throws SQLException;

    public boolean updateProduct(Product Product) throws SQLException;

    public boolean updateProductWithSP(Product Product) throws SQLException;

    public boolean checkEmailExists(String email) throws SQLException;
}
