package ru.learningproject.criteria_query.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "universities")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "founding_date")
    private Date foundingDate;

    @OneToMany(mappedBy = "university",
            fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    public void addStudentToUniversity(Student student) {
        students.add(student);
        student.setUniversity(this);
    }

    public University() {
    }

    public University(String name, Date foundingDate) {
        this.name = name;
        this.foundingDate = foundingDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(Date foundingDate) {
        this.foundingDate = foundingDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foundingDate=" + foundingDate +
                '}';
    }
}
