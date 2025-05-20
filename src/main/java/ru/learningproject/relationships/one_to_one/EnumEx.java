package ru.learningproject.relationships.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ru.learningproject.relationships.one_to_one.entity.Passport;
import ru.learningproject.relationships.one_to_one.entity.Student;

public class EnumEx {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            // PERSIST
////            Student student = new Student("Chanel", "King", 9.1);
////            Student student = new Student("Leo", "Farrell", 8.4);
////              Student student = new Student("Julia", "Dean", 8.7);
////            Student student = new Student("Serena", "Nielsen", 7.2);
//            Student student = new Student("Eric", "Scott", 7.4);
////            student = new Student(null, "Treg", 9.9);
////            student = new Student(null, "Sharp", 9.8);
////            Student student = new Student("Isaac", "Sharp", 9.8);
////            student = new Student("Isaac", "Harper", 9.3);
////            student = new Student("Frankie", "Perry", 8.0);
//
//            Passport passport1 = new Passport("Eric.Scott@gmail.com", 173,
//                    EyeColor.GREEN);
//            student.setPassport(passport1);
//            entityManager.persist(student);

            Student student = entityManager.find(Student.class, 1L);
            System.out.println(student.getPassport());



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
