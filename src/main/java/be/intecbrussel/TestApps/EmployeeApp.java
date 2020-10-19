package be.intecbrussel.TestApps;

import be.intecbrussel.Daos.EmployeeDao;
import be.intecbrussel.Daos.EmployeeDaoImpl;
import be.intecbrussel.Entities.Employee;
import be.intecbrussel.Entities.Office;

public class EmployeeApp {
    public static void main(String[] args) {

        Office office = new Office("12345", "", "phone",
                "addressLine1", "addressLine2",
                "state", "country", "postalCode", "territory");
        Employee employee = new Employee(555,"baetens", "Jeffrey", "jo", "jeffrey@gmail.com", "hr", office   );

        EmployeeDao employeeDao = new EmployeeDaoImpl();

        //employeeDao.updateEmployee(employee);

        //employeeDao.createEmployee(employee);

        //System.out.println(employeeDao.readEmployee("Bow"));

        employeeDao.deleteEmployee(employee);

    }
}
