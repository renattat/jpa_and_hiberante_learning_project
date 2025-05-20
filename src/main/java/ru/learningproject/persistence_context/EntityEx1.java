package ru.learningproject.persistence_context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ru.learningproject.persistence_context.entity.Teacher;

public class EntityEx1 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Teacher teacher1 = new Teacher("Rio", "Berger", "Biology", false);
            Teacher teacher2 = new Teacher("Karina", "Dennis", "Economics", false);
            System.out.println("--->>> entityManager.contains((teacher)): " + entityManager.contains((teacher1)));

            entityManager.persist(teacher1);
            entityManager.persist(teacher2);

            System.out.println("--->>> entityManager.contains((teacher)): " + entityManager.contains((teacher1)));


            transaction.commit();
            System.out.println("--->>> entityManager.contains((teacher)): " + entityManager.contains((teacher1)));

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
