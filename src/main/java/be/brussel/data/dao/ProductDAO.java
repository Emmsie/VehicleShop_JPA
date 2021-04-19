package be.brussel.data.dao;

import be.brussel.entity.Product;

import java.util.List;

public interface ProductDAO {
    Product createProduct(Product product);
    Product readProduct(String productCode);
    List<Product> readAllProducts();
    Product updateProduct(Product product);
    boolean deleteProduct(String productCode);
}
