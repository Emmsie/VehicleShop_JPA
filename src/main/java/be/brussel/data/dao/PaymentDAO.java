package be.brussel.data.dao;

import be.brussel.entity.Payment;

import java.util.List;

public interface PaymentDAO {

    Payment createPayment(Payment payment);
    Payment readPayment(String checkNumber);
    Payment updatePayment(Payment payment);
    boolean deletePayment(String checkNumber);
    List<Payment> readAllPaymentsByCustomerNumber(int customerNumber);
}
