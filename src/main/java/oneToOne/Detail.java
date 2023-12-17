package oneToOne;

import jakarta.persistence.*;

@Entity
@Table(name = "Details")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "scholarship")
    private boolean scholarship;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Detail() {
    }

    public Detail(String phoneNumber, boolean scholarship) {
        this.phoneNumber = phoneNumber;
        this.scholarship = scholarship;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }
}
