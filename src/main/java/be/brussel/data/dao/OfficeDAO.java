package be.brussel.data.dao;

import be.brussel.entity.Office;

public interface OfficeDAO {

    Office createOffice(Office office);
    Office readOffice(String officeCode);
    Office updateOffice(Office office);
    boolean deleteOffice(String officeCode);

}