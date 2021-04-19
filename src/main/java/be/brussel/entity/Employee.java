package be.brussel.entity;

import javax.persistence.*;

@Entity(name = "employees")
@NamedQuery(name = "Employee.readAllEmployees", query = "SELECT e FROM employees e")
public class Employee {

    @Id
    @Column
    private int employeeNumber;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String extension;

    @Column
    private String email;

    @ManyToOne
    @JoinColumn(name = "officeCode")
    private Office office;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reportsTo")
    private Employee reportsTo;

    @Column
    private String jobTitle;

    public Employee() { }

    public Employee(int employeeNumber, String firstName, String lastName, String extension, String email,
                    Office office, Employee reportsTo, String jobTitle) {

        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.extension = extension;
        this.email = email;
        this.office = office;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {

        return String.format("EMPLOYEE  ||  First Name : %-10s  |  Last Name : %-10s  |  E-mail : %-35s  |  Office Code : %5s  |  Job Title : %5s",
                firstName, lastName, email, office.getOfficeCode(), jobTitle);

    }
}
