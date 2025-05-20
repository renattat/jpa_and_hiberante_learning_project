package ru.learningproject.jpql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ru.learningproject.jpql.entity.Student;

public class JPQLEx4 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Student student1 = entityManager.find(Student.class, 3);
            Student student2 = entityManager.find(Student.class, 3);

            Student student3 = (Student) entityManager.createQuery(
                    "SELECT s FROM Student s WHERE s.id = 3")
                    .getSingleResult();





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
