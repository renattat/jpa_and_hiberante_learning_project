package ru.learningproject.advanced_mapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ru.learningproject.advanced_mapping.entity.Employee;
import ru.learningproject.advanced_mapping.entity.Friend;

import java.util.ArrayList;
import java.util.List;

public class ListMappingFriendEx {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            List<Friend> friendsList = new ArrayList<>();
//            Friend friend1 = new Friend("Chanell", "King", 22);
//            Friend friend2 = new Friend("Leo", "Farel", 24);
//            Friend friend3 = new Friend("Julia", "Dean", 23);
//
//            friendsList.add(friend1);
//            friendsList.add(friend2);
//            friendsList.add(friend3);
//
//            Employee employee = new Employee("Michaek", 4000, 15d, friendsList);
//
//            entityManager.persist(employee);

            Employee employee= entityManager.find(Employee.class, 1);
            System.out.println(employee);


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
