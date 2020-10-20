package be.intecbrussel.TestApps;

import be.intecbrussel.Daos.CustomerDao;
import be.intecbrussel.Daos.CustomerDaoImpl;
import be.intecbrussel.Entities.Customer;
import be.intecbrussel.Entities.Employee;

public class CustomerApp {
    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setEmployeeNumber(56);

        Customer customer = new Customer();
        customer.setCustomerNumber(555);
        customer.setSalesRepEmployeeNumber(employee);

        CustomerDao customerDao = new CustomerDaoImpl();

        //customerDao.createCustomer(customer);
        System.out.println(customerDao.readCustomer(103));
        //customerDao.updateCustomer();
        //customerDao.deleteCustomer();
    }
}
