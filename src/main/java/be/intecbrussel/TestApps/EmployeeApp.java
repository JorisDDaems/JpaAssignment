package be.intecbrussel.TestApps;

import be.intecbrussel.Daos.EmployeeDao;
import be.intecbrussel.Daos.EmployeeDaoImpl;
import be.intecbrussel.Entities.Employee;
import be.intecbrussel.Entities.Office;

public class EmployeeApp {
    public static void main(String[] args) {


        Office office = new Office();
        office.setOfficeCode("1");

        Employee employee = new Employee();
        employee.setEmployeeNumber(666);
        employee.setLastName("boccacio");

        employee.setFirstName("jean");
        employee.setEmail("justaboyke69@gmail.com");
        employee.setExtension("ja");
        employee.setJobTitle("sir");
        employee.setOfficeCode(office);


        EmployeeDao employeeDao = new EmployeeDaoImpl();

        //employeeDao.createEmployee(employee);
        //employeeDao.updateEmployee(employee);
        //System.out.println(employeeDao.readEmployee("Bow"));
        employeeDao.deleteEmployee(employee);

    }
}
