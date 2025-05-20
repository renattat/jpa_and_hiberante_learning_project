package ru.learningproject.crud.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//@Entity
//@Table(name = "test_students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false, unique = true)
    private String name;

//    @Column(name = "surname")
    private String surname;

    @Column(name = "avg_grade", nullable = false)
    private Double avgGrade;

    @Transient
    private LocalDateTime createdDate;

    public Student() {
    }

    public Student(String name, String surname, Double abgGrade) {
        this.name = name;
        this.surname = surname;
        this.avgGrade = abgGrade;
        createdDate =  LocalDateTime.now();
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(Double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", avgGrade=" + avgGrade +
                ", createdDate=" + createdDate +
                '}';
    }
}
