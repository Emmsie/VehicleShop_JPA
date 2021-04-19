package be.brussel.service.mapperimpl;

import be.brussel.data.dao.EmployeeDAO;
import be.brussel.data.daoimpl.EmployeeDAOImpl;
import be.brussel.entity.Employee;
import be.brussel.service.mapper.EmployeeMapper;

import java.util.List;

public class EmployeeMapperImpl implements EmployeeMapper {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDAO.createEmployee(employee);
    }

    @Override
    public Employee readEmployee(int id) {
        return employeeDAO.readEmployee(id);
    }

    @Override
    public List<Employee> readAllEmployees() {
        return employeeDAO.readAllEmployees();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeDAO.deleteEmployee(id);
    }
}
