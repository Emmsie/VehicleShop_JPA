package be.brussel.entity;

import be.brussel.exception.officeexception.OfficeException;
import be.brussel.exception.officeexception.OfficeInputIsEmptyException;
import be.brussel.exception.officeexception.OfficeInputTooLongException;

import javax.persistence.*;

@Entity(name = "offices")
public class Office {

    @Id
    @Column(updatable = false, nullable = false)
    private String officeCode;

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

    @Column
    private String territory;

    @Column
    private String phone;

    public Office() { }

    public Office(String officeCode, String addressLine1, String addressLine2, String postalCode,
                  String city, String state, String country, String territory, String phone) throws OfficeException {

        setOfficeCode(officeCode);
        setAddressLine1(addressLine1);
        setAddressLine2(addressLine2);
        setPostalCode(postalCode);
        setCity(city);
        setState(state);
        setCountry(country);
        setTerritory(territory);
        setPhone(phone);
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) throws OfficeException {
        if (officeCode.length() > 10) {
            throw new OfficeInputTooLongException("Office code");
        }
        if (officeCode.trim().length() == 0){
            throw new OfficeInputIsEmptyException("Office code");
        }
        this.officeCode = officeCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) throws OfficeException {
        if (addressLine1.length() > 50) {
            throw new OfficeInputTooLongException("Street name");
        }
        if (addressLine1.trim().length() == 0){
            throw new OfficeInputIsEmptyException("Street name");
        }
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) throws OfficeException {
        if (addressLine2.length() > 50) {
            throw new OfficeInputTooLongException("Building number");
        }
        if (addressLine2.trim().length() == 0){
            throw new OfficeInputIsEmptyException("Building number");
        }
        this.addressLine2 = addressLine2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) throws OfficeException {
        if (postalCode.length() > 15) {
            throw new OfficeInputTooLongException("Postal code");
        }
        if (postalCode.trim().length() == 0){
            throw new OfficeInputIsEmptyException("Postal code");
        }
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws OfficeException {
        if (city.length() > 50) {
            throw new OfficeInputTooLongException("City name");
        }
        if (city.trim().length() == 0){
            throw new OfficeInputIsEmptyException("City name");
        }
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) throws OfficeException {
        if (state.length() > 50) {
            throw new OfficeInputTooLongException("State name");
        }
        if (state.trim().length() == 0){
          throw new OfficeInputIsEmptyException("State name");
        }
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) throws OfficeException {
        if (country.length() > 50) {
            throw new OfficeInputTooLongException("Country name");
        }
        if (country.trim().length() == 0){
            throw new OfficeInputIsEmptyException("Country name");
        }
        this.country = country;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) throws OfficeException {
        if (territory.length() > 10) {
            throw new OfficeInputTooLongException("Territory name");
        }
        if (territory.trim().length() == 0){
            throw new OfficeInputIsEmptyException("Territory name");
        }
        this.territory = territory;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws OfficeException {
        if (phone.length() > 50) {
            throw new OfficeInputTooLongException("Phone number");
        }
        if (phone.trim().length() == 0){
            throw new OfficeInputIsEmptyException("Phone number");
        }
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Office{" +
                "officeCode='" + officeCode + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", territory='" + territory + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
