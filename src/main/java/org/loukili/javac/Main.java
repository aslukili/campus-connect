package org.loukili.javac;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.loukili.javac.entity.*;
import org.loukili.javac.hibernate.HibernateFactory;

public class Main {
  public static void main(String[] args) {
//    EntityManager entityManager = HibernateFactory.getEntityManager();
    Responsible responsable = new Responsible();
    responsable.setFirstName("Abdesalam");
    responsable.setLastName("salim");
    responsable.setResponsibleType(ResponsibleType.TRAINER);
    responsable.setDomain("youcode");
    responsable.setPhoneNumber("0612523455");
    responsable.setRole(Role.RESPONSIBLE);
    Gender homme = Gender.MALE;
    responsable.setGender(homme);
    responsable.setState(State.ACTIVE);
    System.out.println("here");

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();

    entityManager.persist(responsable);
//    System.out.println("name "+entityManager.find(User.class,1).getFirstName());
//    System.out.println("done");
    entityManager.getTransaction().commit();
    entityManager.close();
    entityManagerFactory.close();
//    entityManager.getTransaction().begin();
//    entityManager.createQuery("select user from User user", User.class).getResultList().stream().map(u->u.getFirstName()).forEach(System.out::println);
//    entityManager.getTransaction().commit();
  }
}
