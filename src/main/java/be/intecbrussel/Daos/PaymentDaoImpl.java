package be.intecbrussel.Daos;

import be.intecbrussel.Entities.Orderdetail;
import be.intecbrussel.Entities.Payment;
import be.intecbrussel.Utils.EntityManagerFactoryProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class PaymentDaoImpl implements PaymentDao{

        private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();
        private EntityManager em = null;

        @Override
        public void createPayment (Payment payment) {

            try {
                em = emf.createEntityManager();
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                em.persist(payment);
                tx.commit();
                System.out.println("Payment saved");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        @Override
        public Payment readPayment(int customerNumber) {
            Payment payment = null;
            try {
                em = emf.createEntityManager();
                TypedQuery<Payment> query = em.createQuery("SELECT b from Payment b where b.customerNumber =?1", Payment.class);
                query.setParameter(1, customerNumber);
                payment = query.getSingleResult();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
            return payment;
        }

        @Override
        public void updatePayment (Payment payment) {
            try {
                em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.merge(payment);
                transaction.commit();
                System.out.println("Payment updated");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        @Override
        public void deletePayment (Payment payment) {
            try {
                em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();
                Payment payment1 = em.find(Payment.class, payment.getCustomerNumber());
                transaction.begin();
                em.remove(payment1);
                transaction.commit();
                System.out.println("Payment removed");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
}
