package ru.learningproject.jpql;

import jakarta.persistence.*;
import ru.learningproject.jpql.entity.University;

import java.util.List;

public class JPQLEx3 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            // SELECT universities without students
//            Query query = entityManager.createQuery("SELECT u FROM University u " +
//                    "WHERE u.students is empty");
//            List<University> universities = query.getResultList();
            //**************************************************************************
            // SELECT universities with 1 student
//            Query query = entityManager.createQuery("SELECT u FROM University u " +
//                    "WHERE size(u.students) = 1");
//            List<University> universities = query.getResultList();
            //**************************************************************************
            // SELECT universities by count of students DESC
//            Query query = entityManager.createQuery("SELECT u FROM University u " +
//                    "ORDER BY size(u.students) DESC");
//            List<University> universities = query.getResultList();
            //**************************************************************************
            // JOIN

//            Query query = entityManager.createQuery("SELECT u, s FROM University u, Student s"); // CROSS JOIN
            Query query = entityManager.createQuery("SELECT u, s FROM University u LEFT JOIN u.students s"); // FULL JOIN
            List<Object[]> results = query.getResultList();
            // Object[0] -->> University
            // Object[1] -->> Student
            System.out.println(results.size());
            for(Object[] result: results) {
                System.out.println(result[0] + " --->>> " + result[1]);
            }


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
