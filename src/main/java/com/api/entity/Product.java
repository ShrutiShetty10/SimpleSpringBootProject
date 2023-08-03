package com.api.entity;



import jakarta.persistence.*;


@Entity
@Table(name="Products")
public class Product {


    @Id
    @GeneratedValue
    private int id;
    @Column(name="product_name")
    private String productName;
    @Column(name="quantity")
    private int quantity;
    @Column(name="product_price")
    private double price;

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
