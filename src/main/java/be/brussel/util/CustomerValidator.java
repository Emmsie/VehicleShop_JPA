package be.brussel.util;

import be.brussel.service.mapper.CustomerMapper;
import be.brussel.service.mapperimpl.CustomerMapperImpl;

public class CustomerValidator {
    private static CustomerMapper customerMapper = new CustomerMapperImpl();

    public static boolean isCustomerInDatabase(int customerNumber) {
        return customerMapper.readCustomer(customerNumber) != null;
    }
}
