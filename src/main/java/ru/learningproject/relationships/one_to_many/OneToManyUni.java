package ru.learningproject.relationships.one_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ru.learningproject.relationships.one_to_many.entity.Student;
import ru.learningproject.relationships.one_to_many.entity.University;

import java.sql.Date;

public class OneToManyUni {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            // PERSIST
//            University university = new University("Harvard",
//                    Date.valueOf("1636-10-28"));
//
//            Student student1 = new Student("Roy", "Harper", 7.9);
//            Student student2 = new Student("Kynley", "Boyer", 8.1);
//
//            university.addStudentTOUniversity(student1);
//            university.addStudentTOUniversity(student2);
//
//            entityManager.persist(university);

            // FIND
//            University university = entityManager.find(University.class, 1l);
//            System.out.println(university);
//            System.out.println(university.getStudents());

            //REMOVE
//            University university = entityManager.find(University.class, 1l);
//            Student student3 = new Student("Scarlette", "Fox", 6.7);
//            university.addStudentTOUniversity(student3);
//            Student student = entityManager.find(Student.class, 2l);
//            entityManager.remove(student);

            University university = entityManager.find(University.class, 1l);
            entityManager.remove(university);

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
