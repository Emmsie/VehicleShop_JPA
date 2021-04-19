package be.brussel.util;

import be.brussel.service.mapper.OfficeMapper;
import be.brussel.service.mapperimpl.OfficeMapperImpl;

public class OfficeValidator {
    private static OfficeMapper officeMapper = new OfficeMapperImpl();

    public static boolean isOfficeInDatabase(String officeCode) {
        return officeMapper.readOffice(officeCode) != null;
    }

}
