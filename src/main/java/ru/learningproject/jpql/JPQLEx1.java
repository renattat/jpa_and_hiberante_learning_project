package ru.learningproject.jpql;

import jakarta.persistence.*;
import ru.learningproject.jpql.entity.Student;

import java.util.List;

public class JPQLEx1 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            // ALL Students
            // SELECT * FROM students
//            TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
//            List<Student> students = query.getResultList();

//            List<Student> students = entityManager.createQuery("FROM Student", Student.class).getResultList();
//******************************************************************************************************************
            // All Students with name Leo
//            List<Student> students = entityManager.createQuery("SELECT s FROM Student s " +
//                            "where s.name = 'Leo' ").getResultList();
//******************************************************************************************************************
//             All Students with avg grade > 8.5
//            List<Student> students = entityManager.createQuery("SELECT s FROM Student s " +
//                            "where s.avgGrade > 8.5 ").getResultList();

//******************************************************************************************************************
//             All Students with avg grade between 7 and 8
//            List<Student> students = entityManager.createQuery("SELECT s FROM Student s " +
//                            "where s.avgGrade BETWEEN 7 AND 8 ").getResultList();
//******************************************************************************************************************
            // All Students with 'a' in name
//            List<Student> students = entityManager.createQuery("SELECT s FROM Student s " +
//                            "where s.name like '%a%' ").getResultList();
//******************************************************************************************************************
            // All Students with 'a' or 'A' in name
//            List<Student> students = entityManager.createQuery("SELECT s FROM Student s " +
//                    "where lower(s.name) like '%a%' ").getResultList();
//******************************************************************************************************************
            // All Students without avg grade info
//            List<Student> students = entityManager.createQuery("SELECT s FROM Student s " +
//                    "where s.avgGrade is NULL").getResultList();
//******************************************************************************************************************
            // All Students with 'a' in name and avg grade > 8.5
//         List<Student> students = entityManager.createQuery("SELECT s FROM Student s " +
//             "where s.name like '%l%' AND s.avgGrade > 8.5").getResultList();
//******************************************************************************************************************
            // All Students names and avgGrades
//            List<Object[]> studentInfo = entityManager.createQuery("SELECT s.name, s.avgGrade FROM Student s ").getResultList();
//            //Object[0] - name
//            //Object[1] - avgGrade
//            for (Object[] info : studentInfo) {
//                System.out.println(info[0] + "--->" + info[1]);
//            }
//******************************************************************************************************************
            // MAX avg grade
//            Query query = entityManager.createQuery("SELECT max(s.avgGrade) FROM Student s");
//            double maxGrade = (Double)query.getSingleResult();
//            System.out.println(maxGrade);
//******************************************************************************************************************
            // AVERAGE of avg grade
            Query query = entityManager.createQuery("SELECT avg(s.avgGrade) FROM Student s");
            double avgGrade = (Double)query.getSingleResult();
            System.out.println(avgGrade);


//            System.out.println(studentInfo);
//            System.out.println(studentInfo.size());


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
