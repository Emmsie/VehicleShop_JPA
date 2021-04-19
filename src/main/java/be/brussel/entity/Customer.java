package be.brussel.entity;

import javax.persistence.*;

@Entity(name ="customers")
@NamedQuery(name = "Customer.readAllCustomers", query = "SELECT c FROM customers c")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int customerNumber;

    @Column
    private String customerName;

    @Column
    private String contactFirstName;

    @Column
    private String contactLastName;

    @Column
    private String phone;

    @Column
    private String addressLine1;

    @Column
    private String addressLine2;

    @Column
    private String postalCode;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String country;

    @ManyToOne
    @JoinColumn (name = "salesRepEmployeeNumber")
    private Employee salesRepEmployee;

    @Column
    private double creditLimit;

    public Customer() { }

    public Customer( String customerName, String contactFirstName, String contactLastName, String phone, String addressLine1, String city, String country, Employee salesRepEmployee) {
        this.customerName = customerName;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.country = country;
        this.salesRepEmployee = salesRepEmployee;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employee getSalesRepEmployee() {
        return salesRepEmployee;
    }

    public void setSalesRepEmployee(Employee salesRepEmployee) {
        this.salesRepEmployee = salesRepEmployee;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {

        return String.format("CUSTOMER  ||  Customer Name : %-40s  |  Contact First Name: %-15s  |  Contact Last Name: %-15s  |  Phone : %-25s  |  Address : %-35s  |  City : %-25s  |  Country : %-25s",
                customerName, contactFirstName, contactLastName, phone, addressLine1, city, country);
    }
}
