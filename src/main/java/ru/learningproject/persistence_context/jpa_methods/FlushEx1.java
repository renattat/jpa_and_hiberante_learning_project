package ru.learningproject.persistence_context.jpa_methods;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ru.learningproject.persistence_context.entity.Teacher;

public class FlushEx1 {

//    Teacher teacher1 = new Teacher("Alessadro", "Lozano", "CS", true);
//    Teacher teacher2 = new Teacher("Rio", "Berger", "Biology", false);
//    Teacher teacher3 = new Teacher("Landry", "Shelton", "Math", true);
//
//            entityManager.persist(teacher1);
//            entityManager.persist(teacher2);
//            entityManager.persist(teacher3);

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Teacher teacher1 = entityManager.find(Teacher.class, 1);
            Teacher teacher3 = entityManager.find(Teacher.class, 3);

            teacher1.setSubject("Biology");

            entityManager.flush();

            teacher3.setSubject("Biology");

            Teacher teacherX = entityManager.find(Teacher.class, 100);
            System.out.println(teacherX.getName());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("!!! rollback !!!");
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
