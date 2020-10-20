package be.intecbrussel.TestApps;

import be.intecbrussel.Daos.PaymentDao;
import be.intecbrussel.Daos.PaymentDaoImpl;
import be.intecbrussel.Entities.Payment;

public class PaymentApp {
    public static void main(String[] args) {

        Payment payment = new Payment();

        PaymentDao paymentDao = new PaymentDaoImpl();


    }
}
