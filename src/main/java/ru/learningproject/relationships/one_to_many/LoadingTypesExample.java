package ru.learningproject.relationships.one_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ru.learningproject.relationships.one_to_many.entity.University;

public class LoadingTypesExample {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();


        try {
            University university = entityManager.find(University.class, 1l);
            System.out.println("----->>> University INFO");
            System.out.println(university);

            university.getStudents().size();

            entityManager.close();


            System.out.println("----->>> Students INFO");
            System.out.println(university.getStudents());


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
