package be.brussel.util;

import be.brussel.service.mapper.EmployeeMapper;
import be.brussel.service.mapperimpl.EmployeeMapperImpl;

public class EmployeeValidator {
    private static EmployeeMapper employeeMapper = new EmployeeMapperImpl();

    public static boolean isEmployeeNumberInDatabase(int employeeNumber) {
        return employeeMapper.readEmployee(employeeNumber) != null;
    }
}
