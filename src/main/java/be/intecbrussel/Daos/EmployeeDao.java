package be.intecbrussel.Daos;

import be.intecbrussel.Entities.Employee;

public interface EmployeeDao {

    void createEmployee(Employee employee);
    Employee readEmployee(String employeeLastName);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);

}
