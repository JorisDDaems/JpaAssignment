package be.intecbrussel.TestApps;

import be.intecbrussel.Daos.EmployeeDao;
import be.intecbrussel.Daos.EmployeeDaoImpl;
import be.intecbrussel.Entities.Employee;

import javax.persistence.Embeddable;

public class YvoAp {
    public static void main(String[] args) {

        EmployeeDao employeeDAO = new EmployeeDaoImpl();

        // Create entities
        Employee newEmployee = employeeDAO.readEmployee("Bow");
        newEmployee.setEmployeeNumber(1001);
        System.out.println(newEmployee);
        employeeDAO.createEmployee(newEmployee);
        System.out.println(employeeDAO.readEmployee("Bow"));

// Update entities
        newEmployee.setFirstName("Yvonnick");
        newEmployee.setLastName("Urvoy");
        newEmployee.setEmail("yvonnick.urvoy@gmail.com");
        newEmployee.setJobTitle("Java IoT student");
        newEmployee.setExtension("x1986");
        employeeDAO.updateEmployee(newEmployee);

        System.out.println(employeeDAO.readEmployee("Urvoy"));
    }
}
