package be.brussel.data.daoimpl;

import be.brussel.data.EntityManagerProvider;
import be.brussel.data.dao.OrderDAO;
import be.brussel.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private static final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    @Override
    public Order createOrder(Order order) {

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();

        return order;
    }

    @Override
    public Order readOrder(int id) {

        entityManager.getTransaction().begin();
        Order order = entityManager.find(Order.class, id);
        entityManager.getTransaction().commit();

        return order;
    }

    @Override
    public Order updateOrder(Order order) {
        if (order != null) {

            entityManager.getTransaction().begin();
            order = entityManager.merge(order);
            entityManager.getTransaction().commit();

            return order;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteOrder(int id) {

        entityManager.getTransaction().begin();
        Order order = entityManager.find(Order.class, id);

        if (order != null) {
            entityManager.remove(order);
            entityManager.getTransaction().commit();

            return true;

        } else {
            entityManager.getTransaction().rollback();

            return false;
        }
    }

    @Override
    public List<Order> readAllOrdersByCustomerNumber(int customerNumber) {

        entityManager.getTransaction().begin();
        TypedQuery<Order> typedQuery = entityManager.createNamedQuery("Order.readAllOrdersByCustomerNumber", Order.class);

        typedQuery.setParameter("customerNumber", customerNumber);

        List<Order> queryResult = typedQuery.getResultList();
        entityManager.getTransaction().commit();


        return queryResult;
    }
}
