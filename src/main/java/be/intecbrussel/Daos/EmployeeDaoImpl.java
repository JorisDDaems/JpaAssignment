package be.intecbrussel.Daos;

import be.intecbrussel.Entities.Employee;
import be.intecbrussel.Utils.EntityManagerFactoryProvider;

import javax.persistence.*;

public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createEmployee(Employee employee) {
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();

            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(employee);
            tx.commit();
            System.out.println("Employee saved");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (em != null){
                em.close();
            }
        }
    }

    @Override
    public Employee readEmployee(String employeeLastName) {
        Employee employee = null;
        EntityManager em = null;

        try{
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();

            TypedQuery<Employee> query = em.createQuery("SELECT b from Employee b where b.lastName =?1", Employee.class);
            query.setParameter(1, employeeLastName);
            employee = query.getSingleResult();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (em != null){
                em.close();
            }
        }
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManager em = null;
        try{
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Employee managedEmployee = em.merge(employee);

            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (em != null){
                em.close();
            }
        }
    }

    @Override
    public Employee deleteEmployee(Employee employee) {
        return null;
    }
}
