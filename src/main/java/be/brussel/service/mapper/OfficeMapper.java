package be.brussel.service.mapper;

import be.brussel.entity.Office;

public interface OfficeMapper {

    Office createOffice(String officeCode, String addressLine1, String addressLine2, String postalCode,
                        String city, String state, String country, String territory, String phone);
    Office readOffice(String officeCode);
    Office updateOffice(String officeCode, String addressLine1, String addressLine2, String postalCode,
                        String city, String state, String country, String territory, String phone);
    boolean deleteOffice(String officeCode);
}
