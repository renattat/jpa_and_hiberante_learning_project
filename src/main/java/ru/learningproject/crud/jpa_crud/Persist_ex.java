package ru.learningproject.crud.jpa_crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ru.learningproject.crud.entity.Student;

public class Persist_ex {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        Student student = null;

        try {
            transaction.begin();
//            student = new Student("Leo", "Farrell", 8.4);
//            student = new Student("Julia", "Dean", 8.7);
//            student = new Student("Serena", "Nielsen", 7.2);
//            student = new Student("Eric", "Scott", 7.7);
//            student = new Student(null, "Treg", 9.9);
//            student = new Student(null, "Sharp", 9.8);
//            student = new Student("Isaac", "Sharp", 9.8);
//            student = new Student("Isaac", "Harper", 9.3);
//            student = new Student("Frankie", "Perry", 8.0);
            student = new Student("Chanel", "King", 9.1);
            entityManager.persist(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if(entityManager!=null) {
                entityManager.close();
                factory.close();
            }
        }
        System.out.println(student);


    }
}
