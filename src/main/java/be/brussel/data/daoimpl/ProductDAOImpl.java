package be.brussel.data.daoimpl;

import be.brussel.data.EntityManagerProvider;
import be.brussel.data.dao.ProductDAO;
import be.brussel.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private static final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    @Override
    public Product createProduct(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        return product;
    }

    @Override
    public Product readProduct(String productCode) {
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, productCode);
        entityManager.getTransaction().commit();

        return product;
    }

    @Override
    public List<Product> readAllProducts() {
        entityManager.getTransaction().begin();
        TypedQuery<Product> typedQuery = entityManager.createNamedQuery("Product.readAllProducts", Product.class);
        List<Product> queryResult = typedQuery.getResultList();
        entityManager.getTransaction().commit();

        return queryResult;
    }

    @Override
    public Product updateProduct(Product product) {
        if (product == null) {
            return null;
        }

        entityManager.getTransaction().begin();
        product = entityManager.merge(product);
        entityManager.getTransaction().commit();

        return product;
    }

    @Override
    public boolean deleteProduct(String productCode) {

        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, productCode);

        if (product == null) {
            entityManager.getTransaction().rollback();

            return false;
        }

        entityManager.remove(product);
        entityManager.getTransaction().commit();

        return true;
    }
}
