package be.brussel.data.dao;

import be.brussel.entity.OrderDetail;
import be.brussel.entity.OrderDetailId;

import java.util.List;

public interface OrderDetailDAO {

    OrderDetail createOrderDetail(OrderDetail orderDetail);
    OrderDetail readOrderDetail(OrderDetailId orderDetailId);
    List<OrderDetail> readAllOrderDetailsByOrderNumber(int orderNumber);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    boolean deleteOrderDetail(OrderDetailId orderDetailId);


}
