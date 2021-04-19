package be.brussel.data.daoimpl;

import be.brussel.data.EntityManagerProvider;
import be.brussel.data.dao.OrderDetailDAO;
import be.brussel.entity.OrderDetail;
import be.brussel.entity.OrderDetailId;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    private static final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {

        entityManager.getTransaction().begin();
        entityManager.persist(orderDetail);
        entityManager.getTransaction().commit();

        return orderDetail;
    }

    @Override
    public OrderDetail readOrderDetail(OrderDetailId orderDetailId) {

        entityManager.getTransaction().begin();
        OrderDetail orderDetail = entityManager.find(OrderDetail.class, orderDetailId);
        entityManager.getTransaction().commit();

        return orderDetail;
    }

    @Override
    public List<OrderDetail> readAllOrderDetailsByOrderNumber(int orderNumber) {

        entityManager.getTransaction().begin();
        TypedQuery<OrderDetail> typedQuery = entityManager.createNamedQuery("OrderDetail.readAllOrderDetailsByOrderNumber", OrderDetail.class);

        typedQuery.setParameter("orderNumber", orderNumber);

        List<OrderDetail> queryResult = typedQuery.getResultList();
        entityManager.getTransaction().commit();


        return queryResult;
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        if (orderDetail != null) {

            entityManager.getTransaction().begin();
            orderDetail = entityManager.merge(orderDetail);
            entityManager.getTransaction().commit();

            return orderDetail;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteOrderDetail(OrderDetailId orderDetailId) {

        entityManager.getTransaction().begin();
        OrderDetail orderDetail = entityManager.find(OrderDetail.class, orderDetailId);

        if (orderDetail != null) {
            entityManager.remove(orderDetail);
            entityManager.getTransaction().commit();

            return true;

        } else {
            entityManager.getTransaction().rollback();

            return false;
        }
    }
}
