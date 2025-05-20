package ru.learningproject.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.learningproject.hibernate.entity.Student;

public class HibernateEx2 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Transaction transaction = session.getTransaction();

        try{
//            transaction.begin();
            Student student1 = session.get(Student.class, 2);
            Student student2 = session.get(Student.class, 2);
            Student student100 = session.get(Student.class, 100);

            System.out.println(student100);

//            transaction.commit();
        }
        catch (Exception e) {
            if(transaction!=null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if(session!=null) {
                session.close();
            }
            factory.close();
        }



    }
}
