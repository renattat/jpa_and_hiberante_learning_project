package ru.learningproject.persistence_context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ru.learningproject.persistence_context.entity.Teacher;

public class SecondLevelCacheEx1 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");



        try {
            EntityManager entityManager = factory.createEntityManager();
            System.out.println("FIRST TIME");
            Teacher teacher1 = entityManager.find(Teacher.class, 4L);
            System.out.println(teacher1);
            entityManager.close();

            EntityManager entityManager2 = factory.createEntityManager();
            System.out.println("SECOND TIME");
            Teacher teacher2 = entityManager2.find(Teacher.class, 4L);
            System.out.println(teacher1);
            entityManager2.close();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
