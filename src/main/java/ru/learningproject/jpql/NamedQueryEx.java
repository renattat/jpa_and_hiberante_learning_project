package ru.learningproject.jpql;

import jakarta.persistence.*;
import ru.learningproject.jpql.entity.University;

import java.util.List;

public class NamedQueryEx {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
//            Query query = entityManager.createNamedQuery("University.allUniversitiesLessOrEqualTo2");
            Query query = entityManager.createNamedQuery("University.studentsWithAvgGradeBetween");
            query.setParameter("from", 6);
            query.setParameter("to", 8);
            List<University> universities = query.getResultList();
            System.out.println(universities);

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
