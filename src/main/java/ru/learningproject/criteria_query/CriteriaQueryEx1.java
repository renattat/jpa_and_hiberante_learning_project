package ru.learningproject.criteria_query;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import ru.learningproject.criteria_query.entity.Student;

import java.util.List;

public class CriteriaQueryEx1 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();



        try {
            // JPQL: SELECT s FROM Student s;

            //1 Creation of Criteria Builder
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            //2 Creation of Criteria Query
            CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

            //3 Root creation
            Root<Student> root = criteriaQuery.from(Student.class);// from Student s

            //4 Adding root to Criteria Query
            criteriaQuery.select(root); // select s from Student s

            //5 Query creation
            TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);

            List<Student> students = query.getResultList();


            System.out.println(students.size());
            System.out.println(students);






        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }
    }
}
