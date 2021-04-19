package be.brussel.service.mapperimpl;

import be.brussel.data.dao.CustomerDAO;
import be.brussel.data.daoimpl.CustomerDAOImpl;
import be.brussel.entity.Customer;
import be.brussel.service.mapper.CustomerMapper;

import java.util.List;

public class CustomerMapperImpl implements CustomerMapper {

    private CustomerDAO customerDAO= new CustomerDAOImpl();

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDAO.createCustomer(customer);
    }

    @Override
    public Customer readCustomer(int customerNumber) {
        return customerDAO.readCustomer(customerNumber);
    }

    @Override
    public List<Customer> readAllCustomers() {
        return customerDAO.readAllCustomers();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int customerNumber) {
        return customerDAO.deleteCustomer(customerNumber);
    }
}
