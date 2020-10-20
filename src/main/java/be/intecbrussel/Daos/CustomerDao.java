package be.intecbrussel.Daos;

import be.intecbrussel.Entities.Customer;

public interface CustomerDao {

        void createCustomer(Customer customer);
        Customer readCustomer(int customerNumber);
        void updateCustomer(Customer customer);
        void deleteCustomer(Customer customer);

}
