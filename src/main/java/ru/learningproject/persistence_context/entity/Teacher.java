package ru.learningproject.persistence_context.entity;

import jakarta.persistence.*;

//@Cacheable
//@Entity
//@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "subject")
    private String subject;

    @Column(name = "is_professor")
    private boolean isProfessor;

    public Teacher() {
    }

    public Teacher(String name, String surname, String subject, boolean isProfessor) {
        this.name = name;
        this.surname = surname;
        this.subject = subject;
        this.isProfessor = isProfessor;
    }

    @PrePersist
    void prePersist() {
        System.out.println("@PrePersist");
    }

    @PostPersist
    void postPersist() {
        System.out.println("@PostPersist");
    }

    @PreUpdate
    void preUpdate() {
        System.out.println("@PreUpdate");
    }

    @PostUpdate
    void postUpdate() {
        System.out.println("@PostUpdate");
    }

    @PreRemove
    void preRemove() {
        System.out.println("@PreRemove");
    }

    @PostRemove
    void postRemove() {
        System.out.println("@PostRemove");
    }

    @PostLoad
    void postLoad() {
        System.out.println("@PostLoad");
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isProfessor() {
        return isProfessor;
    }

    public void setProfessor(boolean professor) {
        isProfessor = professor;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", subject='" + subject + '\'' +
                ", isProfessor=" + isProfessor +
                '}';
    }

}
