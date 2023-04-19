package com.techelevator.model;

public class CartItem {

    private int cart_item_id;
    private int user_id;
    private int product_id;
    private int quantity;

    public int getCart_item_id() {return cart_item_id;}
    public void setCart_item_id(int cart_item_id) {this.cart_item_id = cart_item_id;}
    public int getUser_id() {return user_id;}
    public void setUser_id(int user_id) {this.user_id = user_id;}
    public int getProduct_id() {return product_id;}
    public void setProduct_id(int product_id) {this.product_id = product_id;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public CartItem (int cart_item_id, int user_id, int product_id, int quantity) {
        this.cart_item_id = cart_item_id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public CartItem() {

    }
}
