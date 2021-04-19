package be.brussel.service.mapper;

import be.brussel.entity.Employee;

import java.util.List;

public interface EmployeeMapper {

    Employee createEmployee(Employee employee);
    Employee readEmployee(int id);
    List<Employee> readAllEmployees();
    Employee updateEmployee(Employee employee);
    boolean deleteEmployee(int id);
}
