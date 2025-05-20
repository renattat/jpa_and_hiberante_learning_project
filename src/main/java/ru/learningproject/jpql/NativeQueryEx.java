package ru.learningproject.jpql;

import jakarta.persistence.*;
import ru.learningproject.jpql.entity.Student;
import ru.learningproject.jpql.entity.University;

import java.util.List;

public class NativeQueryEx {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
//            Query query = entityManager.createNativeQuery(
//                    "SELECT * FROM students",
//                    Student.class);
//            List<Student> students = query.getResultList();
            //***********************************************************

            Query query = entityManager.createNativeQuery(
                    "SELECT * FROM students " +
                            "WHERE avg_grade > ?1 AND length(name) = ?2",
                    Student.class);
            query.setParameter(1, 8);
            query.setParameter(2, 5);
            List<Student> students = query.getResultList();
            System.out.println(students.size());
            System.out.println(students);

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
