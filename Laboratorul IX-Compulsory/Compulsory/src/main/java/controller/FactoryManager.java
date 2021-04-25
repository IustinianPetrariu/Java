package controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryManager {
    private static EntityManagerFactory emf = null;

    //    private static FactoryManager factoryManager = null;
    private FactoryManager() {
    }

    public static EntityManagerFactory getConnection() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ArtistPersistenceUnit");
        }
        return emf;
    }

}
