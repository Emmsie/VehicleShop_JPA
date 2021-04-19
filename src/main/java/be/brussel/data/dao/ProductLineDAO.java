package be.brussel.data.dao;

import be.brussel.entity.ProductLine;

public interface ProductLineDAO {
    ProductLine createProductLine(ProductLine product);
    ProductLine readProductLine(String productLine);
    ProductLine updateProductLine(ProductLine product);
    boolean deleteProductLine(String productLine);
}
