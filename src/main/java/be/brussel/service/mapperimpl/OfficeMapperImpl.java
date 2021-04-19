package be.brussel.service.mapperimpl;

import be.brussel.data.dao.OfficeDAO;
import be.brussel.data.daoimpl.OfficeDAOImpl;
import be.brussel.entity.Office;
import be.brussel.exception.officeexception.*;
import be.brussel.service.mapper.OfficeMapper;

public class OfficeMapperImpl implements OfficeMapper {
    private OfficeDAO officeDAO = new OfficeDAOImpl();

    @Override
    public Office createOffice(String officeCode, String addressLine1, String addressLine2, String postalCode,
                               String city, String state, String country, String territory, String phone) {
        Office newOffice = null;
        try {
            newOffice = new Office(officeCode, addressLine1, addressLine2, postalCode, city, state, country, territory, phone);
            newOffice = officeDAO.createOffice(newOffice);
        } catch (OfficeException oe) {
            System.err.println(oe.getMessage());
        }

        return newOffice;
    }

    @Override
    public Office readOffice(String officeCode) {
        return officeDAO.readOffice(officeCode);
    }

    @Override
    public Office updateOffice(String officeCode, String addressLine1, String addressLine2, String postalCode,
                               String city, String state, String country, String territory, String phone) {
        Office newOffice = null;
        try {
            newOffice = new Office(officeCode, addressLine1, addressLine2, postalCode, city, state, country, territory, phone);
            newOffice = officeDAO.updateOffice(newOffice);
        } catch (OfficeException oe) {
            System.err.println(oe.getMessage());
        }

        return newOffice;
    }

    @Override
    public boolean deleteOffice(String officeCode) {
        return officeDAO.deleteOffice(officeCode);
    }
}
