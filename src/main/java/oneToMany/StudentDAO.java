package oneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {
     public void addStudent(Student student){
          try(Session session = HibernateSession.getSessionFactory().openSession()){
               Transaction transaction = session.beginTransaction();
               session.persist(student);
               transaction.commit();
          }
     }

     public void deleteStudent(int studentId) {
          try(Session session = HibernateSession.getSessionFactory().openSession()){
               Transaction transaction = session.beginTransaction();
               Student student = session.get(Student.class, studentId);
               if (student != null) {
                    session.remove(student);
               }
               transaction.commit();
          }
     }

     public Student getStudentById(int id) {
          try (Session session = HibernateSession.getSessionFactory().openSession()) {
               return session.get(Student.class, id);
          }
     }

     public List<Student> getAllStudents() {
          try (Session session = HibernateSession.getSessionFactory().openSession()) {
               return session.createQuery("FROM Student", Student.class).list();
          }
     }

}
