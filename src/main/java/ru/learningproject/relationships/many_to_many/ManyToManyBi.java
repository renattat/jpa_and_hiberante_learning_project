package ru.learningproject.relationships.many_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ru.learningproject.relationships.many_to_many.entity.Teacher;
import ru.learningproject.relationships.many_to_many.entity.University;

import java.sql.Date;

public class ManyToManyBi {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            //Persist
            University university = new University("Harvard", Date.valueOf("1636-10-28"));
            Teacher teacher1 = new Teacher("Alessandro", "Lozano", "CS", true);
            Teacher teacher2 = new Teacher("Rio", "Berger", "Biology", false);
            Teacher teacher3 = new Teacher("Landry", "Shelton", "Math", true);

            university.addTeacherToUniversity(teacher1);
            university.addTeacherToUniversity(teacher2);
            university.addTeacherToUniversity(teacher3);

            entityManager.persist(university);
            Teacher teacher4 = new Teacher("Vera", "Walton", "Geography", true);
            University university1 = new University("MIT", Date.valueOf("1861-04-10"));
            University university2 = new University("cambridge", Date.valueOf("1209-01-01"));
            University university3 = new University("Oxford", Date.valueOf("1200-09-01"));

            teacher4.addUniversityToTeacher(university1);
            teacher4.addUniversityToTeacher(university2);
            teacher4.addUniversityToTeacher(university3);
//
//            entityManager.persist(teacher1);

            // FIND
//            University university = entityManager.find(University.class,1);
//            System.out.println(university);
//            System.out.println(university.getTeachers());
//
//            Teacher teacher = entityManager.find(Teacher.class, 4L);
//            System.out.println(teacher);
//            System.out.println(teacher.getUniversities());

            //REMOVE
//            Teacher teacher = entityManager.find(Teacher.class, 4L);
//            University university = entityManager.find(University.class,1);
//            teacher.addUniversityToTeacher(university);
//            entityManager.persist(teacher);

            Teacher teacher = entityManager.find(Teacher.class, 4L);
            entityManager.remove(teacher);




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
