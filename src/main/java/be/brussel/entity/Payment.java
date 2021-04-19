package be.brussel.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "payments")
@NamedQuery(name = "Payment.readAllPaymentsByCustomerNumber",
            query = "SELECT p FROM payments p WHERE customerNumber LIKE :customerNumber")
public class Payment {

    @Id
    @Column
    private String checkNumber;

    @Column
    private LocalDate paymentDate;

    @Column
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerNumber")
    private Customer customer;

    public Payment() { }

    public Payment(String checkNumber, LocalDate paymentDate, double amount, Customer customer) {
        this.checkNumber = checkNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {

        return String.format("PAYMENT  ||  Check Number: %-50s  |  Payment Date: %s  |  Amount: €%9.2f ",
                checkNumber, paymentDate.toString(), amount);

    }
}
