package com.techelevator.dao;

import com.techelevator.model.CartItem;
import java.util.List;

public interface CartDao {

    List<CartItem> getCart(int user_id);

    void addItem(int user_id, int product_id, int quantity);

    void deleteItem(int user_id, int product_id);

    void clearCart(int user_id);

}
