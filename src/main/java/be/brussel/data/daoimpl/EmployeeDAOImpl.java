package be.brussel.data.daoimpl;

import be.brussel.data.EntityManagerProvider;
import be.brussel.data.dao.EmployeeDAO;
import be.brussel.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    @Override
    public Employee createEmployee(Employee employee) {

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        return employee;
    }

    @Override
    public Employee readEmployee(int id) {

        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.getTransaction().commit();

        return employee;
    }

    @Override
    public List<Employee> readAllEmployees() {

        entityManager.getTransaction().begin();
        TypedQuery<Employee> typedQuery = entityManager.createNamedQuery("Employee.readAllEmployees", Employee.class);
        List<Employee> queryResult = typedQuery.getResultList();
        entityManager.getTransaction().commit();

        return queryResult;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (employee == null){
            return null;
        }

        entityManager.getTransaction().begin();
        employee = entityManager.merge(employee);
        entityManager.getTransaction().commit();

        return employee;
    }

    @Override
    public boolean deleteEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.getTransaction().begin();

        if (employee == null) {
            entityManager.getTransaction().rollback();

            return false;
        }

        entityManager.remove(employee);
        entityManager.getTransaction().commit();

        return true;
    }
}
