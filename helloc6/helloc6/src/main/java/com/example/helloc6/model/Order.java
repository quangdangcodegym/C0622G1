package com.example.helloc6.model;

import java.math.BigDecimal;

public class Order {
    private int id;
    private String name;
    private String address;
    private int idStatus;
    private BigDecimal total;

    public Order(){

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Order(int id, String name, String address, int idStatus, BigDecimal total) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.idStatus = idStatus;
        this.total = total;
    }
}
