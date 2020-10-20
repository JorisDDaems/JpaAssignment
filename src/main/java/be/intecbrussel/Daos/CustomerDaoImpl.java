package be.intecbrussel.Daos;

import be.intecbrussel.Entities.Customer;
import be.intecbrussel.Utils.EntityManagerFactoryProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class CustomerDaoImpl implements CustomerDao {

    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();
    private EntityManager em = null;

    @Override
    public void createCustomer(Customer customer) {

        try {
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(customer);
            tx.commit();
            System.out.println("Customer saved");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Customer readCustomer(int customerNumber) {
        Customer customer = null;
        try {
            em = emf.createEntityManager();
            TypedQuery<Customer> query = em.createQuery("SELECT b from Customer b where b.customerNumber =?1", Customer.class);
            query.setParameter(1, customerNumber);
            customer = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(customer);
            transaction.commit();
            System.out.println("Customer updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            Customer cust = em.find(Customer.class, customer.getCustomerNumber());
            transaction.begin();
            em.remove(cust);
            transaction.commit();
            System.out.println("Customer removed");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
