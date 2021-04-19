package be.brussel.data.daoimpl;

import be.brussel.data.EntityManagerProvider;
import be.brussel.data.dao.ProductLineDAO;
import be.brussel.entity.ProductLine;

import javax.persistence.EntityManager;

public class ProductLineDAOImpl implements ProductLineDAO {
    private static final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    @Override
    public ProductLine createProductLine(ProductLine productLine) {

        entityManager.getTransaction().begin();
        entityManager.persist(productLine);
        entityManager.getTransaction().commit();

        return productLine;
    }

    @Override
    public ProductLine readProductLine(String productLineId) {

        entityManager.getTransaction().begin();
        ProductLine productLine = entityManager.find(ProductLine.class, productLineId);
        entityManager.getTransaction().commit();

        return productLine;
    }

    @Override
    public ProductLine updateProductLine(ProductLine productLine) {
        if (productLine == null) {
            return null;
        }

        entityManager.getTransaction().begin();
        productLine = entityManager.merge(productLine);
        entityManager.getTransaction().commit();

        return productLine;
    }

    @Override
    public boolean deleteProductLine(String productLineId) {

        entityManager.getTransaction().begin();
        ProductLine productLine = entityManager.find(ProductLine.class, productLineId);

        if (productLine == null) {
            entityManager.getTransaction().rollback();

            return false;
        }

        entityManager.remove(productLine);
        entityManager.getTransaction().commit();

        return true;
    }
}
