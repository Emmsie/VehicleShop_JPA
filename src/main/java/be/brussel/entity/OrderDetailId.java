package be.brussel.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailId implements Serializable {

    @ManyToOne
    @JoinColumn (name = "orderNumber")
    private Order order;

    @ManyToOne
    @JoinColumn (name = "productCode")
    private Product product;

    public OrderDetailId() { }

    public OrderDetailId(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public Order getOrder() {
        return this.order;
    }

    public Product getProduct() {
        return this.product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailId that = (OrderDetailId) o;
        return order.equals(that.order) &&
                product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }

    @Override
    public String toString() {
        return "OrderDetailId{" +
                "order=" + order +
                ", product=" + product +
                '}';
    }
}
