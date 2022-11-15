package org.loukili.javac.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.loukili.javac.entity.Exercise;
import org.loukili.javac.hibernate.HibernateFactory;

import java.util.List;

public class ExerciseDao  implements Idao<Exercise>{
  Transaction transaction = null;

  private EntityManager em = HibernateFactory.getEntityManager();
  private Session session = em.unwrap(Session.class);


  @Override
  public Exercise find(long id) {
    return null;
  }

  @Override
  public List<Exercise> getAll() {
    List activities = null;
    try  {
      transaction = session.beginTransaction();
      Query query = session.createQuery("from Exercise");
      activities = query.getResultList();
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    return activities;
  }

  @Override
  public Exercise add(Exercise exercise) {
    transaction = (Transaction) em.getTransaction();
    transaction.begin();
    em.persist(exercise);
    transaction.commit();
    return exercise;
  }

  @Override
  public void update(Exercise entity) {

  }

  @Override
  public boolean delete(long id) {
    return false;
  }
}
