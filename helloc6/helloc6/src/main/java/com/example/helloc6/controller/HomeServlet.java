package com.example.helloc6.controller;

import com.example.helloc6.dao.IProductDAO;
import com.example.helloc6.dao.IProductDTODAO;
import com.example.helloc6.dao.ProductDAO;
import com.example.helloc6.dao.ProductDTODAO;
import com.example.helloc6.model.Product;
import com.example.helloc6.model.dto.ProductDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "")
public class HomeServlet extends HttpServlet {
    private IProductDTODAO iProductDTODAO;
    @Override
    public void init() throws ServletException {
        iProductDTODAO = new ProductDTODAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> listProduct = iProductDTODAO.selectAllProductDTOs();

        req.setAttribute("listProductDTO", listProduct);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/frontend/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
