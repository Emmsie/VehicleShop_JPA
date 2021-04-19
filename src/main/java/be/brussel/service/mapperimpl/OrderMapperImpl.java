package be.brussel.service.mapperimpl;

import be.brussel.data.dao.OrderDAO;
import be.brussel.data.daoimpl.OrderDAOImpl;
import be.brussel.entity.Order;
import be.brussel.service.mapper.OrderMapper;

import java.util.List;

public class OrderMapperImpl implements OrderMapper {

    private OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public Order createOrder(Order order) {
        return orderDAO.createOrder(order);
    }

    @Override
    public Order readOrder(int id) {
        return orderDAO.readOrder(id);
    }

    @Override
    public List<Order> readAllOrdersByCustomerNumber(int customerNumber){
        return orderDAO.readAllOrdersByCustomerNumber(customerNumber);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    @Override
    public boolean deleteOrder(int id) {
        return orderDAO.deleteOrder(id);
    }
}
