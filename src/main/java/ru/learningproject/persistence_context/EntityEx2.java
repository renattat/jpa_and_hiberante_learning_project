package ru.learningproject.persistence_context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ru.learningproject.persistence_context.entity.Teacher;

public class EntityEx2 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Teacher teacher = entityManager.find(Teacher.class, 2l);
            System.out.println("--->>> entityManager.contains((teacher)): " + entityManager.contains((teacher)));

            entityManager.remove(teacher);
            System.out.println("--->>> entityManager.contains((teacher)): " + entityManager.contains((teacher)));


            transaction.commit();
            System.out.println("--->>> entityManager.contains((teacher)): " + entityManager.contains((teacher)));

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }
    }
}
