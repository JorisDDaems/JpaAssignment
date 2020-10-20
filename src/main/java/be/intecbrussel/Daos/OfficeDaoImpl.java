package be.intecbrussel.Daos;

import be.intecbrussel.Entities.Office;
import be.intecbrussel.Utils.EntityManagerFactoryProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.*;


public class OfficeDaoImpl implements OfficeDao {


    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();
    private EntityManager em = null;

    @Override
    public void createOffice(Office office) {

        try {
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(office);
            tx.commit();
            System.out.println("Office saved");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Office readOffice(String officeCode) {
        Office office = null;
        try {
            em = emf.createEntityManager();
            TypedQuery<Office> query = em.createQuery("SELECT b from Office b where b.officeCode =?1", Office.class);
            query.setParameter(1, officeCode);
            office = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return office;
    }

    @Override
    public void updateOffice(Office office) {
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(office);
            transaction.commit();
            System.out.println("Office updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteOffice(Office office) {
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            Office office1 = em.find(Office.class, office.getOfficeCode());
            transaction.begin();
            em.remove(office1);
            transaction.commit();
            System.out.println("Office removed");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
