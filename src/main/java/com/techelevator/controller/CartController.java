package com.techelevator.controller;

import com.techelevator.dao.CartDao;
import com.techelevator.model.CartItem;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@PreAuthorize("isAuthenticated()")

public class CartController {
    private CartDao dao;
    public CartController (CartDao cartDao) {this.dao = cartDao;}

    @GetMapping
    public List<CartItem> getCart(int user_id) {
        return dao.getCart(user_id);
    }

    @PostMapping (path = "/items")
    public void addItem() {

    }

    @DeleteMapping (path = "items/{id}")
    public void deleteItem() {

    }

    @DeleteMapping
    public void clearCart() {

    }
}
