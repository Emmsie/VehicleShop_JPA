package be.brussel.service.mapper;

import be.brussel.entity.OrderDetail;
import java.util.List;

public interface OrderDetailMapper {

    OrderDetail createOrderDetail(OrderDetail orderDetail);
    OrderDetail readOrderDetail(int orderNumber, String productCode);
    List<OrderDetail> readAllOrderDetailsByOrderNumber(int orderNumber);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    boolean deleteOrderDetail(int orderNumber, String productCode);

}
