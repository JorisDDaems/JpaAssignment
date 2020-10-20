package be.intecbrussel.Daos;

import be.intecbrussel.Entities.Employee;
import be.intecbrussel.Entities.Payment;

public interface PaymentDao {

        void createPayment(Payment payment);
        Payment readPayment(int customerNumber);
        void updatePayment(Payment payment);
        void deletePayment(Payment payment);

}
