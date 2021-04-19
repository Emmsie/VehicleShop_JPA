package be.brussel.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "orders")
@NamedQuery(name = "Order.readAllOrdersByCustomerNumber", query = "SELECT o FROM orders o WHERE customerNumber LIKE :customerNumber")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int orderNumber;

    @ManyToOne
    @JoinColumn(name = "customerNumber")
    private Customer customer;

    @Column
    private LocalDate orderDate;

    @Column
    private LocalDate requiredDate;

    @Column
    private LocalDate shippedDate;

    @Column
    private String status;

    @Column
    private String comments;

    public Order() { }

    public Order(Customer customer, LocalDate orderDate, LocalDate requiredDate, String comments) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.status = Status.IN_PROCESS.getStatusString();
        this.comments = comments;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public LocalDate getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDate shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {

        return String.format("ORDER  ||  Order Number: %-5d  |  Customer Name: %s  |  Order Date: %s  |  Status: %s  ",
                orderNumber, customer.getCustomerName(), orderDate.toString(), status);

    }

    private enum Status {
        CANCELLED("Cancelled"),
        DISPUTED("Disputed"),
        IN_PROCESS("In Process"),
        ON_HOLD("On Hold"),
        RESOLVED("Resolved"),
        SHIPPED("Shipped");

        String statusString;

        Status(String string) {
            this.statusString = string;
        }

        public String getStatusString() {
            return statusString;
        }
    }
}
