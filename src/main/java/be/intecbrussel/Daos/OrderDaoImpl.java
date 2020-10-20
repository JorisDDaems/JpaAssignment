package be.intecbrussel.Daos;

import be.intecbrussel.Entities.Order;
import be.intecbrussel.Utils.EntityManagerFactoryProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class OrderDaoImpl implements OrderDao {


    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();
    private EntityManager em = null;

    @Override
    public void createOrder(Order order) {

        try {
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(order);
            tx.commit();
            System.out.println("Order saved");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Order readOrder(int orderNumber) {
        Order order = null;
        try {
            em = emf.createEntityManager();
            TypedQuery<Order> query = em.createQuery("SELECT b from Order b where b.orderNumber =?1", Order.class);
            query.setParameter(1, orderNumber);
            order = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(order);
            transaction.commit();
            System.out.println("Order updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteOrder(Order order) {
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            Order order1 = em.find(Order.class, order.getOrderNumber());
            transaction.begin();
            em.remove(order1);
            transaction.commit();
            System.out.println("Order removed");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
