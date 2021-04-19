package be.brussel.view;

import be.brussel.entity.*;
import be.brussel.service.mapper.*;
import be.brussel.service.mapperimpl.*;
import be.brussel.util.CustomerValidator;

import java.util.List;
import java.util.Scanner;

public class BusinessAppView {

    public static void optionsMenu(){
        System.out.println("Choose an option");
        System.out.println("1: Display all products");
        System.out.println("2: Display all employees");
        System.out.println("3: Display all customers");
        System.out.println("4: Display individual customer");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("1")
                && !input.equals("2")
                && !input.equals("3")
                && !input.equals("4")) {

            System.err.println("Not a valid number! please try again!");
            input = scanner.nextLine();
        }

        int inputNumber = Integer.parseInt(input);

        switch (inputNumber) {
            case 1:
                showAllProducts();
                break;

            case 2:
                showAllEmployees();
                break;

            case 3:
                showAllCustomers();
                break;

            case 4:
                showCustomer(scanner);
                break;
        }

        scanner.close();
    }

    private static void showAllProducts(){
        ProductMapper productMapper = new ProductMapperImpl();
        List<Product> productList = productMapper.readAllProducts();

        System.out.println("\nProduct Database:\n");
        productList.forEach(System.out::println);
    }

    private static void showAllEmployees(){
        EmployeeMapper employeeMapper = new EmployeeMapperImpl();
        List<Employee> employeeList = employeeMapper.readAllEmployees();

        System.out.println("\nEmployee Database:\n");
        employeeList.forEach(System.out::println);
    }

    private static void showAllCustomers(){
        CustomerMapper customerMapper = new CustomerMapperImpl();
        List<Customer> customerList = customerMapper.readAllCustomers();

        System.out.println("\nCustomer Database:\n");
        customerList.forEach(System.out::println);
    }

    private static void showCustomer(Scanner scanner) {
        CustomerMapper customerMapper = new CustomerMapperImpl();
        OrderMapper orderMapper = new OrderMapperImpl();
        OrderDetailMapper orderDetailMapper = new OrderDetailMapperImpl();
        PaymentMapper paymentMapper = new PaymentMapperImpl();

        int customerNumber = askCustomerNumber(scanner);

        showCustomerDetails(customerMapper, customerNumber);
        showCustomerOrders(orderMapper, orderDetailMapper, customerNumber);
        showCustomerPayments(paymentMapper, customerNumber);
    }

    private static int askCustomerNumber(Scanner scanner) {
        System.out.println("Enter customer number");
        int customerNumber = -1;
        boolean isCustomerInDatabase = CustomerValidator.isCustomerInDatabase(customerNumber);

        while (!isCustomerInDatabase) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                continue;
            }

            try {
                customerNumber = Integer.parseInt(input);

            } catch (NumberFormatException nfe) {
                System.err.println("Customer number is not valid! Please enter a number!");
                continue;
            }
            isCustomerInDatabase = CustomerValidator.isCustomerInDatabase(customerNumber);

            if (!isCustomerInDatabase) {
                System.err.println("Customer is not in our database! Please try again!");
            }
        }

        return customerNumber;
    }


    private static void showCustomerDetails(CustomerMapper customerMapper, int customerNumber) {
        Customer customer = customerMapper.readCustomer(customerNumber);

        String customerName = customer.getCustomerName();
        String contactFirstName = customer.getContactFirstName();
        String contactLastName = customer.getContactLastName();
        String phone = customer.getPhone();
        String address = customer.getAddressLine1() + " " + customer.getAddressLine2();
        String city = customer.getCity();
        String country = customer.getCountry();

        System.out.println("\nCustomer Details:\n");
        System.out.printf("Customer Name : %s %nContact First Name: %s %nContact Last Name: %s %nPhone : %s  %nAddress : %s  %nCity : %s  %nCountry : %s %n",
                customerName, contactFirstName, contactLastName, phone, address, city, country);
    }

    private static void showCustomerOrders(OrderMapper orderMapper, OrderDetailMapper orderDetailMapper, int customerNumber) {
        List<Order> orderList = orderMapper.readAllOrdersByCustomerNumber(customerNumber);

        System.out.println("\nCustomer Orders:");
        for (Order order: orderList) {
            List<OrderDetail> orderDetailList = orderDetailMapper.readAllOrderDetailsByOrderNumber(order.getOrderNumber());
            System.out.println();
            System.out.println(order);
            orderDetailList.forEach(System.out::println);
        }
    }

    private static void showCustomerPayments(PaymentMapper paymentMapper, int customerNumber) {
        List<Payment> paymentList = paymentMapper.readAllPaymentsByCustomerNumber(customerNumber);
        System.out.println("\nCustomer Payments:\n");
        paymentList.forEach(System.out::println);
    }
}
