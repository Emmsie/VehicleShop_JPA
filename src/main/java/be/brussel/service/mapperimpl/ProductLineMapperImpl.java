package be.brussel.service.mapperimpl;

import be.brussel.data.daoimpl.ProductLineDAOImpl;
import be.brussel.entity.ProductLine;
import be.brussel.service.mapper.ProductLineMapper;

public class ProductLineMapperImpl implements ProductLineMapper {
    ProductLineDAOImpl dao = new ProductLineDAOImpl();

    @Override
    public ProductLine createProductLine(ProductLine product) {
        return dao.createProductLine(product);
    }

    @Override
    public ProductLine readProductLine(String productLine) {
        return dao.readProductLine(productLine);
    }

    @Override
    public ProductLine updateProductLine(ProductLine product) {
        return dao.updateProductLine(product);
    }

    @Override
    public boolean deleteProductLine(String productLine) {
        return dao.deleteProductLine(productLine);
    }
}
