package ru.learningproject.jpql;

import jakarta.persistence.*;
import ru.learningproject.jpql.entity.Student;

import java.util.List;

public class FlushEx {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Student student = entityManager.find(Student.class, 1);
            student.setAvgGrade(9.0);
            Double avgGrade = (Double) entityManager.createQuery(
                            "SELECT s.avgGrade from Student s where s.id = 1")
                                .getSingleResult();
            System.out.println(avgGrade);


            transaction.commit();

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
