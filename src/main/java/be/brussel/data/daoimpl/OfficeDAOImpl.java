package be.brussel.data.daoimpl;

import be.brussel.data.EntityManagerProvider;
import be.brussel.data.dao.OfficeDAO;
import be.brussel.entity.Office;

import javax.persistence.EntityManager;

public class OfficeDAOImpl implements OfficeDAO {

    private static final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    @Override
    public Office createOffice(Office office) {

        entityManager.getTransaction().begin();
        entityManager.persist(office);
        entityManager.getTransaction().commit();

        return office;
    }

    @Override
    public Office readOffice(String officeCode) {

        entityManager.getTransaction().begin();
        Office office = entityManager.find(Office.class, officeCode);
        entityManager.getTransaction().commit();

        return office;
    }

    @Override
    public Office updateOffice(Office office) {

        if (office == null){
            return null;
        }

        entityManager.getTransaction().begin();
        office = entityManager.merge(office);
        entityManager.getTransaction().commit();

        entityManager.close();
        return office;
    }

    @Override
    public boolean deleteOffice(String officeCode) {

        Office office = entityManager.find(Office.class, officeCode);

        if (office == null) {
            entityManager.getTransaction().rollback();
            entityManager.close();

            return false;
        }
        entityManager.getTransaction().begin();
        entityManager.remove(office);
        entityManager.getTransaction().commit();

        return true;
    }
}
