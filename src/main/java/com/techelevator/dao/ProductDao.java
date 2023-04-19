package com.techelevator.dao;

import com.techelevator.model.Product;
import java.util.List;

public interface ProductDao {

    List<Product> getAllProducts();

    List<Product> getProductName(String name);

    List<Product> getProductSKU(int product_sku);

    List<Product> getProductNameSKU(int product_sku, String name);

    Product getProductID (int product_id);

}
