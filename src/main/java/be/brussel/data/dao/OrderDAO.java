package be.brussel.data.dao;

import be.brussel.entity.Order;

import java.util.List;

public interface OrderDAO {
    Order createOrder(Order order);
    Order readOrder(int id);
    Order updateOrder(Order order);
    boolean deleteOrder(int id);
    List<Order> readAllOrdersByCustomerNumber(int customerNumber);
}