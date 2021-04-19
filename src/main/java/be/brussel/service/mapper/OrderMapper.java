package be.brussel.service.mapper;

import be.brussel.entity.Order;

import java.util.List;

public interface OrderMapper {

    Order createOrder(Order order);
    Order readOrder(int id);
    List<Order> readAllOrdersByCustomerNumber(int customerNumber);
    Order updateOrder(Order order);
    boolean deleteOrder(int id);

}
