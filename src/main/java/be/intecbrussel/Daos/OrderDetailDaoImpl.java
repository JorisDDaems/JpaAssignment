package be.intecbrussel.Daos;

import be.intecbrussel.Entities.Order;
import be.intecbrussel.Entities.Orderdetail;
import be.intecbrussel.Utils.EntityManagerFactoryProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class OrderDetailDaoImpl implements OrderDetailDao {

    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();
    private EntityManager em = null;

    @Override
    public void createOrderDetail(Orderdetail orderdetail) {

        try {
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(orderdetail);
            tx.commit();
            System.out.println("Orderdetail saved");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Orderdetail readOrderDetail(int orderNumber) {
        Orderdetail orderdetail = null;
        try {
            em = emf.createEntityManager();
            TypedQuery<Orderdetail> query = em.createQuery("SELECT b from Orderdetail b where b.orderNumber =?1", Orderdetail.class);
            query.setParameter(1, orderNumber);
            orderdetail = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return orderdetail;
    }

    @Override
    public void updateOrderDetail (Orderdetail orderdetail) {
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(orderdetail);
            transaction.commit();
            System.out.println("Orderdetail updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteOrderDetail(Orderdetail orderdetail) {
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            Orderdetail order1 = em.find(Orderdetail.class, orderdetail.getOrderNumber());
            transaction.begin();
            em.remove(order1);
            transaction.commit();
            System.out.println("Orderdetail removed");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
