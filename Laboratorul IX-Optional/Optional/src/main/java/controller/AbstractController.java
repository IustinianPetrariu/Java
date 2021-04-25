package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AbstractController<T, E> {
    private EntityManagerFactory emf;

    public AbstractController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(E object)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        em.close();
    }

}
