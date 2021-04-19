package be.brussel.service.mapper;

import be.brussel.entity.ProductLine;

public interface ProductLineMapper {
    ProductLine createProductLine(ProductLine product);
    ProductLine readProductLine(String productLine);
    ProductLine updateProductLine(ProductLine product);
    boolean deleteProductLine(String productLine);
}
