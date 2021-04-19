package be.brussel.service.mapper;

import be.brussel.entity.Product;

import java.util.List;

public interface ProductMapper {
    Product createProduct(Product product);
    Product readProduct(String productCode);
    List<Product> readAllProducts();
    Product updateProduct(Product product);
    boolean deleteProduct(String productCode);
}
