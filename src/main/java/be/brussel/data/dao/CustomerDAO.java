package be.brussel.data.dao;

import be.brussel.entity.Customer;

import java.util.List;

public  interface CustomerDAO {

    Customer createCustomer(Customer customer);
    Customer readCustomer(int customerNumber);
    List<Customer> readAllCustomers();
    Customer updateCustomer(Customer customer);
    boolean deleteCustomer(int customerNumber);

}
