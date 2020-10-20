package be.intecbrussel.Daos;

import be.intecbrussel.Entities.Payment;
import be.intecbrussel.Entities.Product;
import be.intecbrussel.Utils.EntityManagerFactoryProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class ProductDaoImpl implements ProductDao{

        private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();
        private EntityManager em = null;

        @Override
        public void createProduct (Product product) {

            try {
                em = emf.createEntityManager();
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                em.persist(product);
                tx.commit();
                System.out.println("Product saved");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        @Override
        public Product readProduct (String productCode) {
            Product product = null;
            try {
                em = emf.createEntityManager();
                TypedQuery<Product> query = em.createQuery("SELECT b from Product b where b.productCode =?1", Product.class);
                query.setParameter(1, productCode);
                product = query.getSingleResult();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
            return product;
        }

        @Override
        public void updateProduct (Product product) {
            try {
                em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.merge(product);
                transaction.commit();
                System.out.println("Product updated");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        @Override
        public void deleteProduct (Product product) {
            try {
                em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();
                Product product1 = em.find(Product.class, product.getProductCode());
                transaction.begin();
                em.remove(product1);
                transaction.commit();
                System.out.println("Product removed");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
}
