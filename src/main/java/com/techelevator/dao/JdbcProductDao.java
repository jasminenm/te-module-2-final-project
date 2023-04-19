package com.techelevator.dao;

import com.techelevator.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcProductDao (JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Product> getAllProducts () {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT product_id, product_sku, name, description, price, image_name" +
                "FROM product";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Product product = mapRowToProduct(results);
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> getProductName (String name) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT product_id, product_sku, name, description, price, image_name" +
                "FROM product" +
                "WHERE name LIKE ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");
        while (results.next()) {
            Product product = mapRowToProduct(results);
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> getProductSKU (int product_sku) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT product_id, product_sku, name, description, price, image_name" +
                "FROM product" +
                "WHERE product_SKU LIKE ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + product_sku + "%");
        while (results.next()) {
            Product product = mapRowToProduct(results);
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> getProductNameSKU (int product_sku, String name) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT product_id, product_sku, name, description, price, image_name" +
                "FROM product" +
                "WHERE product_SKU LIKE ? AND name LIKE ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + product_sku + "%", "%" + name + "%");
        while (results.next()) {
            Product product = mapRowToProduct(results);
            products.add(product);
        }
        return products;
    }

    @Override
    public Product getProductID (int product_id) {
        Product product = new Product();
        String sql = "SELECT product_id, product_sku, name, description, price, image_name" +
                "FROM product" +
                "WHERE product_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, product_id);
        if (results.next()) {
            return mapRowToProduct(results);
        }
        return product;
    }

    private Product mapRowToProduct (SqlRowSet results) {
        Product product = new Product();
        product.setProductID(results.getInt("product_id"));
        product.setProductSKU(results.getInt("product_sku"));
        product.setName(results.getString("name"));
        product.setDescription(results.getString("description"));
        product.setPrice(results.getBigDecimal("price"));
        product.setImageName(results.getString("image_name"));
        return product;

    }

}
