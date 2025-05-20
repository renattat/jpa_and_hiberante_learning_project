package ru.learningproject.inheritance_mapping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends Employee {

    @Column(name = "subject")
    private String subject;

    @Column(name = "is_professor")
    private Boolean is_professor;

    public Teacher() {
    }

    public Teacher(String name, Integer salary, Double experience, String subject, Boolean is_professor) {
        super(name, salary, experience);
        this.subject = subject;
        this.is_professor = is_professor;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getIs_professor() {
        return is_professor;
    }

    public void setIs_professor(Boolean is_professor) {
        this.is_professor = is_professor;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + getId() + '\'' +
                "name='" + getName() + '\'' +
                "salary='" + getSalary() + '\'' +
                "experience='" + getExperience() + '\'' +
                "subject='" + subject + '\'' +
                ", is_professor=" + is_professor +
                "} " + super.toString();
    }
}
