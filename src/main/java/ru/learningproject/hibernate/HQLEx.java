package ru.learningproject.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.learningproject.hibernate.entity.Student;
import ru.learningproject.relationships.one_to_one.entity.Passport;

import java.util.List;

public class HQLEx {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            // ALL Students
            // SELECT * FROM students
//            Query<Student> query = session.createQuery("from Student");
//            List<Student> students = query.getResultList();
//            for (Student student: students) {
//                System.out.println(student);
//            }

            // ALL Students where name with 'L' or 'l' and grade > 8
//            List<Student> students = session.createQuery("from Student s where lower(s.name) like '%l%' " +
//                    "and s.avgGrade > 8").getResultList();
//            for (Student student : students) {
//                System.out.println(student);
//            }

            // UPDATE
//            session.createQuery("update Student set avgGrade = 10.0 where length(name)=5")
//                            .executeUpdate();

            // DELETE
            session.createQuery("delete Student where avgGrade < 9").executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }


    }
}
