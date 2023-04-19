package com.techelevator.model;

import java.math.BigDecimal;

public class Product {

    private int product_id;
    private int product_sku;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageName;

    public int getProductID() {return product_id;}
    public void setProductID(int productID) {this.product_id = productID;}
    public int getProductSKU() {return product_sku;}
    public void setProductSKU(int productSKU) {this.product_sku = productSKU;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public BigDecimal getPrice() {return price;}
    public void setPrice(BigDecimal price) {this.price = price;}
    public String getImageName () {return imageName;}
    public void setImageName (String imageName) {this.imageName = imageName;}

    public Product(int product_id, int product_sku, String name, String description, BigDecimal price, String imageName) {
        this.product_id = product_id;
        this.product_sku = product_sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageName = imageName;
    }

    public Product() {

    }
}
