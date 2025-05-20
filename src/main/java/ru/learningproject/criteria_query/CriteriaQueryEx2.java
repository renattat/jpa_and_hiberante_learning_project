package ru.learningproject.criteria_query;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import ru.learningproject.criteria_query.entity.Student;

import java.util.List;

public class CriteriaQueryEx2 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();



        try {
//            // JPQL: SELECT s.name FROM Student s;
//
//            //1 Creation of Criteria Builder
//            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//
//            //2 Creation of Criteria Query
//            CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
//
//            //3 Root creation
//            Root<Student> root = criteriaQuery.from(Student.class);// from Student s
//
//            //4 Adding root to Criteria Query
//            criteriaQuery.select(root.get("name")); // select s.name from Student s
//
//            //5 Query creation
//            TypedQuery<String> query = entityManager.createQuery(criteriaQuery);
//
//            List<String> names = query.getResultList();
//
//
//            System.out.println(names.size());
//            System.out.println(names);
            //****************************************************************

            // JPQL: SELECT s FROM Student s WHERE avgGrade >= 7.5;

            //1 Creation of Criteria Builder
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            //2 Creation of Criteria Query
            CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

            //3 Root creation
            Root<Student> root = criteriaQuery.from(Student.class);// from Student s

            //3.1 Condition creation
            Predicate predicate = criteriaBuilder.greaterThanOrEqualTo(root.get("avgGrade"),7.5);

            //3.2 Adding condition to Criteria Query
            criteriaQuery.where(predicate);

            //4 Adding root to Criteria Query
            criteriaQuery.select(root); // select s from Student s where s.avgGrade >= 7.5

            //5 Query creation
            TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);

            List<Student> student = query.getResultList();


            System.out.println(student.size());
            System.out.println(student);






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
