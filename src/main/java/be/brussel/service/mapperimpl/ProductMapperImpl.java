package be.brussel.service.mapperimpl;

import be.brussel.data.dao.ProductDAO;
import be.brussel.data.daoimpl.ProductDAOImpl;
import be.brussel.entity.Product;
import be.brussel.service.mapper.ProductMapper;

import java.util.List;

public class ProductMapperImpl implements ProductMapper {
    ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public Product createProduct(Product product) {
        return productDAO.createProduct(product);
    }

    @Override
    public Product readProduct(String productCode) {
        return productDAO.readProduct(productCode);
    }

    @Override
    public List<Product> readAllProducts() {
        return productDAO.readAllProducts();
    }

    @Override
    public Product updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(String productCode) {
        return productDAO.deleteProduct(productCode);
    }
}
