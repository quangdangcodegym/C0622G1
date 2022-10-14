package com.example.helloc6.dao;

import com.example.helloc6.model.Image;
import com.example.helloc6.model.Product;
import com.example.helloc6.model.dto.ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDTODAO extends DatabaseQuery implements IProductDTODAO{
    private IProductDAO iProductDAO;
    private IImageDAO iImageDAO;

    public ProductDTODAO(){
        iProductDAO = new ProductDAO();
        iImageDAO = new ImageDAO();
    }

    @Override
    public void insertProductDTO(ProductDTO ProductDTO) throws SQLException {
        
    }

    @Override
    public ProductDTO selectProductDTO(int id) {
        return null;
    }

    @Override
    public List<ProductDTO> selectAllProductDTOs() {
        List<ProductDTO> listProductDTO = new ArrayList<>();
        List<Product> listProduct = iProductDAO.selectAllProducts();
        try{
            for(Product p : listProduct){
                ProductDTO productDTO = new ProductDTO();
                List<Image> imageList = iImageDAO.selectImagesByProductId(p.getId());
                productDTO.setProductToProductDTO(p);
                productDTO.setImagesToProductDTO(imageList);

                listProductDTO.add(productDTO);
            }
        }catch (SQLException ex){
            printSQLException(ex);
        }

        return listProductDTO;
    }

    @Override
    public boolean deleteProductDTO(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateProductDTO(ProductDTO ProductDTO) throws SQLException {
        return false;
    }

    @Override
    public boolean updateProductDTOWithSP(ProductDTO ProductDTO) throws SQLException {
        return false;
    }
}
