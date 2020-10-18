package be.intecbrussel.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "employees", schema = "classicmodels")
@Embeddable
public class Employee implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JoinColumn(name = "employeeNumber")
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String jobTitle;


    private String officeCode;

    private int reportsTo;

    public Employee(){}

    public Employee(int employeeNumber, String lastName, String firstName, String extension, String email, String jobTitle, String officeCode, int reportsTo) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.jobTitle = jobTitle;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber){this.employeeNumber = employeeNumber;}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public int getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(int reportsTo) {
        this.reportsTo = reportsTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeNumber == employee.employeeNumber &&
                reportsTo == employee.reportsTo &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(extension, employee.extension) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(jobTitle, employee.jobTitle) &&
                Objects.equals(officeCode, employee.officeCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, lastName, firstName, extension, email, jobTitle, officeCode, reportsTo);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", officeCode='" + officeCode + '\'' +
                ", reportsTo=" + reportsTo +
                '}';
    }
}
