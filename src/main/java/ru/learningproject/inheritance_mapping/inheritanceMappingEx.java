package ru.learningproject.inheritance_mapping;

import jakarta.persistence.*;
import ru.learningproject.inheritance_mapping.entity.Driver;
import ru.learningproject.inheritance_mapping.entity.Employee;
import ru.learningproject.inheritance_mapping.entity.Teacher;

import java.util.List;

public class inheritanceMappingEx {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            Teacher teacher = new Teacher("Alessandro", 2500, 8d, "cs", true);
//            Driver driver = new Driver("Peter", 2300, 15d, 'B', "BMW");
//
//            entityManager.persist(teacher);
//            entityManager.persist(driver);

            Query query = entityManager.createQuery("SELECT emp FROM Employee emp");
            List<Employee> employees = query.getResultList();
            System.out.println(employees.size());
            System.out.println(employees);
            System.out.println("========================\n");

            Query query2 = entityManager.createQuery("SELECT dr from Driver dr");
            List<Driver> drivers = query2.getResultList();
            System.out.println(drivers.size());
            System.out.println(drivers);

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
