package be.brussel.view;

import be.brussel.entity.Employee;
import be.brussel.entity.Office;
import be.brussel.service.mapper.EmployeeMapper;
import be.brussel.service.mapper.OfficeMapper;
import be.brussel.service.mapperimpl.EmployeeMapperImpl;
import be.brussel.service.mapperimpl.OfficeMapperImpl;
import be.brussel.util.EmployeeValidator;
import be.brussel.util.OfficeValidator;

import java.util.Scanner;

public class OfficeAppView {

    public static void optionsMenu() {
        System.out.println("Choose an option");
        System.out.println("1: Create new office");
        System.out.println("2: Transfer employee to other office");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("1")
                && !input.equals("2")) {

            System.err.println("Not a valid number, please try again!");
            input = scanner.nextLine();
        }

        int inputNumber = Integer.parseInt(input);
        switch (inputNumber){
            case 1:
                createNewOffice(scanner);
                break;

            case 2:
                transferEmployee(scanner);
                break;
        }

        scanner.close();
    }

    private static void createNewOffice(Scanner scanner) {
        OfficeMapper officeMapper = new OfficeMapperImpl();
        String officeCode = askNewOfficeCode(scanner);

        String addressLine1 = askOfficeData("street name", 50, scanner);
        String addressLine2 = askOfficeData("building number", 50, scanner);
        String postalCode = askOfficeData("postal code", 15, scanner);
        String city = askOfficeData("city", 50, scanner);
        String state = askOfficeData("state", 50, scanner);
        String country = askOfficeData("country", 50 , scanner);
        String territory = askOfficeData("territory", 10, scanner);
        String phone = askOfficeData("phone number", 50, scanner);

        officeMapper.createOffice(officeCode, addressLine1, addressLine2, postalCode, city, state, country, territory, phone);
    }

    private static String askNewOfficeCode(Scanner scanner) {
        System.out.println("Enter office code: ");
        String officeCode = "";
        boolean isOfficeInDatabase = OfficeValidator.isOfficeInDatabase(officeCode);

        while (officeCode.length() > 10 || officeCode.isEmpty() || isOfficeInDatabase ) {
            officeCode = scanner.nextLine();
            if (officeCode.length() > 10) {
                System.err.println("Office code is longer than 10! Please try again!");
            }
            isOfficeInDatabase = OfficeValidator.isOfficeInDatabase(officeCode);

            if (isOfficeInDatabase) {
                System.err.println("Office code is already in the database! Please try again!");
            }
        }
        return officeCode;
    }


    private static String askOfficeData(String enteredData, int length, Scanner scanner) {
        System.out.println("Enter " + enteredData);
        String input = "";

        enteredData = enteredData.substring(0,1).toUpperCase() + enteredData.substring(1);

        while (input.length() > length || input.isEmpty()) {
            input = scanner.nextLine();

            if (input.length() > length) {
                System.err.printf("%s is longer than %d! Please try again!%n" , enteredData, length);
            }

        }
        return input;
    }

    private static void transferEmployee(Scanner scanner) {
        EmployeeMapper employeeMapper = new EmployeeMapperImpl();
        OfficeMapper officeMapper = new OfficeMapperImpl();

        int employeeNumber = askEmployeeNumber(scanner);

        String officeCode = askDatabaseOfficeCode(scanner);

        Employee employee = employeeMapper.readEmployee(employeeNumber);
        Office office = officeMapper.readOffice(officeCode);
        employee.setOffice(office);
        employeeMapper.updateEmployee(employee);

        System.out.printf("\nEmployee %s %s has been successfully transferred to office %s.\n",
                employee.getFirstName(), employee.getLastName(), officeCode);
    }

    private static String askDatabaseOfficeCode(Scanner scanner) {
        System.out.println("Enter new office code");
        String officeCode = "";

        while (!OfficeValidator.isOfficeInDatabase(officeCode) || officeCode.isEmpty()) {
            officeCode = scanner.nextLine();

            if (officeCode.isEmpty()) {
                continue;
            }

            if (!OfficeValidator.isOfficeInDatabase(officeCode)) {
                System.err.println("Office code is not in our database! Please try again!");
            }
        }
        return officeCode;
    }

    private static int askEmployeeNumber(Scanner scanner) {
        System.out.println("Enter employee number");
        int employeeNumber = -1;

        while (!EmployeeValidator.isEmployeeNumberInDatabase(employeeNumber)) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                continue;
            }

            try {
                employeeNumber = Integer.parseInt(input);

            } catch (NumberFormatException nfe) {
                System.err.println("Employee number is not valid! Please enter a number!");
                continue;
            }

            if (!EmployeeValidator.isEmployeeNumberInDatabase(employeeNumber)) {
                System.err.println("Employee is not in our database! Please try again!");
            }
        }
        return employeeNumber;
    }

}