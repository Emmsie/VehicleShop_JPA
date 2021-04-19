package be.brussel.data.daoimpl;

import be.brussel.data.EntityManagerProvider;
import be.brussel.data.dao.PaymentDAO;
import be.brussel.entity.Payment;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    private static final EntityManager entityManager = EntityManagerProvider.getEntityManager();
    @Override
    public Payment createPayment(Payment payment) {

        entityManager.getTransaction().begin();
        entityManager.persist(payment);
        entityManager.getTransaction().commit();

        return payment;
    }

    @Override
    public Payment readPayment(String checkNumber) {

        entityManager.getTransaction().begin();
        Payment payment = entityManager.find(Payment.class, checkNumber);
        entityManager.getTransaction().commit();

        return payment;
    }

    @Override
    public Payment updatePayment(Payment payment) {
        if (payment == null){
            return null;
        }

        entityManager.getTransaction().begin();
        payment = entityManager.merge(payment);
        entityManager.getTransaction().commit();

        return payment;
    }

    @Override
    public boolean deletePayment(String checkNumber) {

        entityManager.getTransaction().begin();
        Payment payment = entityManager.find(Payment.class, checkNumber);

        if (payment == null) {
            entityManager.getTransaction().rollback();

            return false;
        }

        entityManager.remove(payment);
        entityManager.getTransaction().commit();

        return true;
    }

    @Override
    public List<Payment> readAllPaymentsByCustomerNumber(int customerNumber) {

        entityManager.getTransaction().begin();
        TypedQuery<Payment> typedQuery = entityManager.createNamedQuery("Payment.readAllPaymentsByCustomerNumber", Payment.class);

        typedQuery.setParameter("customerNumber", customerNumber);

        List<Payment> queryResult = typedQuery.getResultList();
        entityManager.getTransaction().commit();


        return queryResult;
    }
}
