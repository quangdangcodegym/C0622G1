package com.example.helloc6.model.dto;

import com.example.helloc6.model.Image;
import com.example.helloc6.model.Product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProductDTO {
    private int id;
    private String name;
    private BigDecimal price;
    private Date createAt;
    private Date updateAt;
    private String description;
    private List<Image> listImages;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProductToProductDTO(Product product){

        this.id = product.getId();
        this.name = product.getName();
        this.createAt = product.getCreateAt();
        this.updateAt = product.getUpdateAt();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }

    public void setImagesToProductDTO(List<Image> imageList){
        this.listImages = imageList;
    }
    public ProductDTO(){}
    public ProductDTO(int id, String name, Date createAt, Date updateAt, String description) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.description = description;
    }

    public ProductDTO(int id, String name, Date createAt, Date updateAt, String description, List<Image> listImages) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.description = description;
        this.listImages = listImages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getListImages() {
        return listImages;
    }

    public void setListImages(List<Image> listImages) {
        this.listImages = listImages;
    }
}
