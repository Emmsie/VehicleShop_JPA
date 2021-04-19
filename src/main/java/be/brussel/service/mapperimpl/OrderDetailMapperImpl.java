package be.brussel.service.mapperimpl;

import be.brussel.data.dao.OrderDetailDAO;
import be.brussel.data.daoimpl.OrderDetailDAOImpl;
import be.brussel.entity.Order;
import be.brussel.entity.OrderDetail;
import be.brussel.entity.OrderDetailId;
import be.brussel.entity.Product;
import be.brussel.service.mapper.OrderDetailMapper;
import be.brussel.service.mapper.OrderMapper;
import be.brussel.service.mapper.ProductMapper;

import java.util.List;

public class OrderDetailMapperImpl implements OrderDetailMapper {

    private OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
    private ProductMapper productMapper = new ProductMapperImpl();
    private OrderMapper orderMapper = new OrderMapperImpl();

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return orderDetailDAO.createOrderDetail(orderDetail);
    }

    @Override
    public OrderDetail readOrderDetail(int orderNumber, String productCode) {

        Product product = productMapper.readProduct(productCode);
        Order order = orderMapper.readOrder(orderNumber);

        OrderDetailId orderDetailId = new OrderDetailId(order, product);

        return orderDetailDAO.readOrderDetail(orderDetailId);
    }

    @Override
    public List<OrderDetail> readAllOrderDetailsByOrderNumber(int orderNumber) {
        return orderDetailDAO.readAllOrderDetailsByOrderNumber(orderNumber);
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailDAO.updateOrderDetail(orderDetail);
    }

    @Override
    public boolean deleteOrderDetail(int orderNumber, String productCode) {
        Product product = productMapper.readProduct(productCode);
        Order order = orderMapper.readOrder(orderNumber);

        OrderDetailId orderDetailId = new OrderDetailId(order, product);

        return orderDetailDAO.deleteOrderDetail(orderDetailId);
    }
}
