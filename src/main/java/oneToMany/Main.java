package oneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        Course course1 = new Course();
        course1.setName("Math");

        Course course2 = new Course();
        course2.setName("CS");

        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(course1);
            session.persist(course2);
            transaction.commit();
        }

        Student student1 = new Student();
        student1.setName("Student1");
        student1.setEmail("Student1@gmail.com");
        student1.setCourseId(course1.getId());
        studentDAO.addStudent(student1);

        Student student2 = new Student();
        student2.setName("Student2");
        student2.setEmail("Student2@gmail.com");
        student2.setCourseId(course1.getId());
        studentDAO.addStudent(student2);


        Student student3 = new Student();
        student3.setName("Student3");
        student3.setEmail("Student3@gmail.com");
        student3.setCourseId(course2.getId());
        studentDAO.addStudent(student3);

        Student student4 = new Student();
        student4.setName("Student4");
        student4.setEmail("Student4@gmail.com");
        student4.setCourseId(course2.getId());
        studentDAO.addStudent(student4);
    }
}
