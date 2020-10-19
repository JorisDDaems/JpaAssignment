package be.intecbrussel.TestApps;

import be.intecbrussel.Daos.EmployeeDao;
import be.intecbrussel.Daos.EmployeeDaoImpl;
import be.intecbrussel.Entities.Employee;
import be.intecbrussel.Entities.Office;

public class EmployeeApp {
    public static void main(String[] args) {

        Office office = new Office("officeCode", "city", "phone",
                "addressLine1", "addressLine2",
                "state", "country", "postalCode", "territory");
        Employee employee = new Employee(1000,"Baetens", "Jeffrey", "jo", "jeffrey@gmail.com", "hr", office   );

        EmployeeDao employeeDao = new EmployeeDaoImpl();

        employeeDao.createEmployee(employee);

        System.out.println(employeeDao.readEmployee("Bow"));

    }
}
