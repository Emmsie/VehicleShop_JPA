package be.brussel.data.daoimpl;

import be.brussel.data.EntityManagerProvider;
import be.brussel.data.dao.CustomerDAO;
import be.brussel.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private static final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    @Override
    public Customer createCustomer(Customer customer) {

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();

        return customer;
    }

    @Override
    public Customer readCustomer(int customerNumber) {

        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, customerNumber);
        entityManager.getTransaction().commit();

        return customer;
    }

    @Override
    public List<Customer> readAllCustomers() {

        entityManager.getTransaction().begin();
        TypedQuery<Customer> typedQuery = entityManager.createNamedQuery("Customer.readAllCustomers", Customer.class);
        List<Customer> queryResult = typedQuery.getResultList();
        entityManager.getTransaction().commit();

        return queryResult;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if (customer == null){
            return null;
        }

        entityManager.getTransaction().begin();
        customer = entityManager.merge(customer);
        entityManager.getTransaction().commit();

        return customer;
    }

    @Override
    public boolean deleteCustomer(int customerNumber) {

        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, customerNumber);

        if (customer == null) {
            entityManager.getTransaction().rollback();

            return false;
        }

        entityManager.remove(customer);
        entityManager.getTransaction().commit();

        return true;
    }
}
