package be.brussel.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity (name = "orderdetails")
@NamedQuery(name = "OrderDetail.readAllOrderDetailsByOrderNumber",
            query = "SELECT o FROM orderdetails o WHERE orderNumber LIKE :orderNumber")

public class OrderDetail implements Serializable {

    @EmbeddedId
    private OrderDetailId orderDetailId;

    @Column
    private int quantityOrdered;

    @Column
    private double priceEach;

    @Column
    private short orderLineNumber;

    public OrderDetail() { }

    public OrderDetail(Order order, Product product, int quantityOrdered, short orderLineNumber) {
        this.orderDetailId = new OrderDetailId(order, product);
        this.quantityOrdered = quantityOrdered;
        this.priceEach = product.getMSRP();
        this.orderLineNumber = orderLineNumber;
    }

    public OrderDetailId getOrderDetailId() {
        return orderDetailId;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    public short getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    @Override
    public String toString() {

        return String.format("ORDER DETAILS  ||  Product Name: %-40s  |  Quantity: %5d  |  Price Each: €%7.2f",
                orderDetailId.getProduct().getProductName(), quantityOrdered, priceEach);

    }
}