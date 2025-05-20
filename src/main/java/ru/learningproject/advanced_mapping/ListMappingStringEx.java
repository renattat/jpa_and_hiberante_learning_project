package ru.learningproject.advanced_mapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ru.learningproject.advanced_mapping.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class ListMappingStringEx {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            List<String> friendsNames1 = new ArrayList<>();
//            friendsNames1.add("Channel");
//            friendsNames1.add("Leo");
//            friendsNames1.add("Julia");

//            List<String> friendsNames2 = new ArrayList<>();
//            friendsNames2.add("Roy");
//            friendsNames2.add("Kynlee");
//            friendsNames2.add("Eric");

//            Employee employee1 = new Employee("Michael", 4000, 15d, friendsNames1);
//            Employee employee2 = new Employee("Rudolf", 3500, 10d, friendsNames2);

//            entityManager.persist(employee2);

//            Employee employee = entityManager.find(Employee.class, 1);
//            System.out.println(employee);

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
