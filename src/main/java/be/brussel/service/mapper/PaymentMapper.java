package be.brussel.service.mapper;

import be.brussel.entity.Payment;
import java.util.List;

public interface PaymentMapper {

    Payment createPayment(Payment payment);
    Payment readPayment(String checkNumber);
    List<Payment> readAllPaymentsByCustomerNumber(int customerNumber);
    Payment updatePayment(Payment payment);
    boolean deletePayment(String checkNumber);

}
