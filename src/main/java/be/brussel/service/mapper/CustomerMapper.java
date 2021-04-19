package be.brussel.service.mapper;

import be.brussel.entity.Customer;

import java.util.List;

public interface CustomerMapper {

    Customer createCustomer(Customer customer);
    Customer readCustomer(int customerNumber);
    List<Customer> readAllCustomers();
    Customer updateCustomer(Customer customer);
    boolean deleteCustomer(int customerNumber);
}
