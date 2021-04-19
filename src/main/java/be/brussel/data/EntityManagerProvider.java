package be.brussel.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("OpdrachtMDMA");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
