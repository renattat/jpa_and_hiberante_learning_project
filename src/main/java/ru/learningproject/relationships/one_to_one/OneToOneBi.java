package ru.learningproject.relationships.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ru.learningproject.relationships.one_to_one.entity.Passport;
import ru.learningproject.relationships.one_to_one.entity.Student;

public class OneToOneBi {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            Student student = new Student("Chanel", "King", 9.1);
//            Student student = new Student("Leo", "Farrell", 8.4);
//            Student student = new Student("Julia", "Dean", 8.7);
//            Student student = new Student("Serena", "Nielsen", 7.2);
//            student = new Student("Eric", "Scott", 7.7);
//            student = new Student(null, "Treg", 9.9);
//            student = new Student(null, "Sharp", 9.8);
//            Student student = new Student("Isaac", "Sharp", 9.8);
//            student = new Student("Isaac", "Harper", 9.3);
//            Student student = new Student("Frankie", "Perry", 5.8);
//            Passport passport = new Passport("Frankie.Perry@gmail.com", 185,
//                    "brawn");
//            passport.setStudent(student);
//            student.setPassport(passport);
//            entityManager.persist(passport);

            //FIND
//            Passport passport = entityManager.find(Passport.class, 2L);
//            System.out.println(passport);
//            System.out.println(passport.getStudent());

            //REMOVE
            Passport passport = entityManager.find(Passport.class, 3L);
            passport.getStudent().setPassport(null);

            entityManager.remove(passport);



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
