package be.brussel.service.mapperimpl;

import be.brussel.data.dao.PaymentDAO;
import be.brussel.data.daoimpl.PaymentDAOImpl;
import be.brussel.entity.Payment;
import be.brussel.service.mapper.PaymentMapper;

import java.util.List;

public class PaymentMapperImpl implements PaymentMapper {

    private PaymentDAO paymentDAO = new PaymentDAOImpl();

    @Override
    public Payment createPayment(Payment payment) {
        return paymentDAO.createPayment(payment);
    }

    @Override
    public Payment readPayment(String checkNumber) {
        return paymentDAO.readPayment(checkNumber);
    }

    @Override
    public List<Payment> readAllPaymentsByCustomerNumber(int customerNumber) {
        return paymentDAO.readAllPaymentsByCustomerNumber(customerNumber);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentDAO.updatePayment(payment);
    }

    @Override
    public boolean deletePayment(String checkNumber) {
        return paymentDAO.deletePayment(checkNumber);
    }
}
