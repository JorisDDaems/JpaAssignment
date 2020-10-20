package be.intecbrussel.Daos;

import be.intecbrussel.Entities.ProductLine;
import be.intecbrussel.Utils.EntityManagerFactoryProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class ProductLineDaoImpl implements ProductLineDao {

        private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();
        private EntityManager em = null;

        @Override
        public void createProductLine (ProductLine productLine) {

            try {
                em = emf.createEntityManager();
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                em.persist(productLine);
                tx.commit();
                System.out.println("Productline saved");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        @Override
        public ProductLine readProductLine(String productLine) {
            ProductLine productLine1 = null;
            try {
                em = emf.createEntityManager();
                TypedQuery<ProductLine> query = em.createQuery("SELECT b from ProductLine b where b.productLine =?1", ProductLine.class);
                query.setParameter(1, productLine);
                productLine1 = query.getSingleResult();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
            return productLine1;
        }

        @Override
        public void updateProductLine (ProductLine productLine) {
            try {
                em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.merge(productLine);
                transaction.commit();
                System.out.println("Productline updated");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        @Override
        public void deleteProductline (ProductLine productLine) {
            try {
                em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();
                ProductLine productLine1 = em.find(ProductLine.class, productLine.getProductLine());
                transaction.begin();
                em.remove(productLine1);
                transaction.commit();
                System.out.println("Productline removed");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
}
