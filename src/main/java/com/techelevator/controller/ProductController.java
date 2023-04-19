package com.techelevator.controller;

import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/products")
@PreAuthorize("permitAll")

public class ProductController {

    private ProductDao dao;
    public ProductController (ProductDao productDao) {this.dao = productDao;}

    @GetMapping
    public List<Product> getAllProducts () {
        return dao.getAllProducts();
    }

    @GetMapping
    public List<Product> getProductName(@RequestParam(defaultValue = "") String productName) {
        return dao.getProductName(productName);
    }

    @GetMapping
    public List<Product> getProductSKU(@RequestParam(defaultValue = "") int productSKU) {
        return dao.getProductSKU(productSKU);
    }

    @GetMapping List<Product> getProductNameSKU(@RequestParam(defaultValue = "") int product_sku,
                                                @RequestParam(defaultValue = "") String name) {
        return dao.getProductNameSKU(product_sku, name);
    }

    @GetMapping (path = "/{id}") Product getProductID(@RequestParam(defaultValue = "") int product_id) {
        return dao.getProductID(product_id);
    }
}
