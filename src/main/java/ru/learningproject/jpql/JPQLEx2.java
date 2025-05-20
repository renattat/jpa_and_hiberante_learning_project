package ru.learningproject.jpql;

import jakarta.persistence.*;
import ru.learningproject.jpql.entity.Student;

import java.util.List;

public class JPQLEx2 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            // All Students with 'l' in name and avg grade > 8.5
//            Query query = entityManager.createQuery("SELECT s FROM Student s " +
//                    "where s.name like ?1 AND s.avgGrade > ?2 ");
//            query.setParameter(1, "%l%");
//            query.setParameter(2, 8.5);
//            List<Student> students = query.getResultList();


//******************************************************************************************************************
            // All Students with 'l' in name and avg grade > 8.5
//            Query query = entityManager.createQuery("SELECT s FROM Student s " +
//                    "where s.name like :letter AND s.avgGrade > :grade ");
//            query.setParameter("letter", "%l%");
//            query.setParameter("grade", 8.5);
//            List<Student> students = query.getResultList();

//            System.out.println(students);
//            System.out.println(students.size());
//******************************************************************************************************************
            // UPDATE
//            Query query = entityManager.createQuery("update Student s set avgGrade = 7.0 " +
//                    " where length(surname)>6" );
//            query.executeUpdate();
//******************************************************************************************************************
            // DELETE
            Query query = entityManager.createQuery("delete Student s where s.avgGrade<7.5 or s.avgGrade is NUll" );
            query.executeUpdate();




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
