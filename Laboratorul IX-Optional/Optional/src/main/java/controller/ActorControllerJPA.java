package controller;

import entity.ActorJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class ActorControllerJPA {
    private EntityManagerFactory emf;

    public ActorControllerJPA(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(ActorJPA artist) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
        em.close();
    }

    public ActorJPA findByName(String name) {
        EntityManager em = emf.createEntityManager();
        String sqlQuery = "SELECT * FROM ACTORS WHERE NAME = ?";
        Query query = em.createNativeQuery(sqlQuery, ActorJPA.class);
        query.setParameter(1, name);
        List<ActorJPA> actorJPAS = query.getResultList();
        return actorJPAS.isEmpty() ? null : (ActorJPA) actorJPAS.get(0);

    }

    public ActorJPA findByid(int id) {
        EntityManager em = emf.createEntityManager();
        String sqlQuery = "SELECT * FROM ACTORS WHERE ID = ?";
        Query query = em.createNativeQuery(sqlQuery, ActorJPA.class);
        query.setParameter(1, id);
        List<ActorJPA> actorJPAS = query.getResultList();
        return actorJPAS.isEmpty() ? null : (ActorJPA) actorJPAS.get(0);

    }
}
