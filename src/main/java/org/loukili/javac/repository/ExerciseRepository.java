package org.loukili.javac.repository;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;

import org.loukili.javac.entity.Exercise;
import org.loukili.javac.hibernate.HibernateFactory;

public class ExerciseRepository implements IFilterRepository<Exercise> {
    private EntityManager em = HibernateFactory.getEntityManager();
    private Session session = em.unwrap(Session.class);
    @Override
    public Exercise getAllAndCount() {
        return null;
    }

    @Override
    public long getCount() {
        em.getTransaction().begin();
        long countExercise = (long) em.createQuery("SELECT count(exe) FROM Exercise exe ").getSingleResult();
        em.getTransaction().commit();
        return countExercise;
    }
}
