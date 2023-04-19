package com.techelevator.dao;

import com.techelevator.model.CartItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCartDao implements CartDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcCartDao (JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<CartItem> getCart(int user_id) {
        List<CartItem> cart = new ArrayList<>();
        String sql = "SELECT cart_item.cart_item_id, cart_item.user_id, cart_item.product_id, cart_item.quantity, product.price, product.name" +
                "FROM cart_item" +
                "JOIN product on cart_item.product_id = product.product_id" +
                "WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user_id);
        while (results.next()) {
            CartItem cartItem = mapRowToCart(results);
            cart.add(cartItem);
        }
        return cart;
    }

    @Override
    public void addItem(int user_id, int product_id, int quantity) {
        String sql = "SELECT * FROM cart_item" +
                "WHERE user_id = ? AND product_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user_id, product_id);
        if (results.next()) {
            String update = "UPDATE cart_item SET quantity" +
                    "WHERE user_id = ? AND product_id = ?";
        } else {
            String add = "INSERT INTO cart_item (user_id, product_id, quantity)" +
                         "VALUES (?, ?, ?)";
            jdbcTemplate.update(add, user_id, product_id, quantity);
        }
    }

    @Override
    public void deleteItem(int user_id, int product_id) {
        String sql = "DELETE FROM cart_item" +
                   "WHERE user_id = ? AND product_id = ?";
    }

    @Override
    public void clearCart(int user_id) {
        String sql = "DELETE FROM cart_item" +
                "WHERE user_id = ?";
    }

    private CartItem mapRowToCart(SqlRowSet results) {
       CartItem cartItem = new CartItem();
       cartItem.setCart_item_id(results.getInt("cart_item_id"));
       cartItem.setUser_id(results.getInt("user_id"));
       cartItem.setProduct_id(results.getInt("product_id"));
       cartItem.setProduct_id(results.getInt("quantity"));
       return cartItem;
    }
}
