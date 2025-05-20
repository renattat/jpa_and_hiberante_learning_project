package ru.learningproject.criteria_query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import ru.learningproject.criteria_query.entity.Student;
import ru.learningproject.criteria_query.entity.University;

import java.util.List;

public class CriteriaQueryEx3 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();



        try {
//            // JPQL: SELECT s.name, s.avgGrade FROM Student s;
//
//            //1 Creation of Criteria Builder
//            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//
//            //2 Creation of Criteria Query
//            CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
//
//            //3 Root creation
//            Root<Student> root = criteriaQuery.from(Student.class);// from Student s
//
//            //4 Adding root to Criteria Query
//            criteriaQuery.multiselect(root.get("name"), root.get("avgGrade")); // select s.name from Student s
//
//            //5 Query creation
//            TypedQuery<Object[]> query = entityManager.createQuery(criteriaQuery);
//
//            List<Object[]> studentInfo = query.getResultList();
//
//
//            System.out.println(studentInfo.size());
//            for(Object[] info: studentInfo) {
//                System.out.println(info[0] + " --->>> " + info[1]);
//            }
            //*********************************************************************

            // JPQL: SELECT u, s FROM University u JOIN u.students s

            //1 Creation of Criteria Builder
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            //2 Creation of Criteria Query
            CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);

            //3 Root creation
            Root<University> root = criteriaQuery.from(University.class);// from University u

            //3.1 JOIN
            Join<University, Student> join =  root.join("students");

            //4 Adding root to Criteria Query
            criteriaQuery.multiselect(root, join); // SELECT u, s FROM University u JOIN u.students s

            //5 Query creation
            TypedQuery<Object[]> query = entityManager.createQuery(criteriaQuery);

            List<Object[]> studentInfo = query.getResultList();


            System.out.println(studentInfo.size());
            for(Object[] info: studentInfo) {
                System.out.println(info[0] + " --->>> " + info[1]);
            }


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
