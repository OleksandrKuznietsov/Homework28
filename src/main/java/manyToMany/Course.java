package manyToMany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "course_name")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "students_courses",
    joinColumns = @JoinColumn(name = "courses_id"),
    inverseJoinColumns = @JoinColumn(name = "students_id"))
    private List<Student> students;

    public Course() {
    }

    public Course(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
