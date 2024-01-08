package oneToOne;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();


        for (int i = 1; i <= 5; i++) {
            Detail detail = new Detail();
            detail.setPhoneNumber("+" + i + "4214214124214");
            detail.setScholarship(i % 2 == 0);
            Student student = new Student("Student" + i, "Student" + i + "@gmail.com", detail);
            detail.setStudent(student);
            studentDAO.addStudent(student);
        }

        System.out.println(studentDAO.getStudentById(5));


        studentDAO.deleteStudent(3);

        System.out.println(studentDAO.getAllStudents());
    }
}
