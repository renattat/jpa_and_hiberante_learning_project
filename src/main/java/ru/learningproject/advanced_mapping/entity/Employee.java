package ru.learningproject.advanced_mapping.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "employees")
public class Employee {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "experience")
    private Double experience;

    @ElementCollection
    @CollectionTable(name = "emp_friends", joinColumns = @JoinColumn(name = "emp_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "emp_name")),
            @AttributeOverride(name = "surname", column = @Column(name = "emp_surname")),
            @AttributeOverride(name = "age", column = @Column(name = "emp_age")),
    })
    List<Friend> friends = new ArrayList<>();

//    @ElementCollection
//    @CollectionTable(name = "emp_friends", joinColumns = @JoinColumn(name = "emp_id"))
//    @Column(name = "friend_name")
//    List<String> friends = new ArrayList<>();

//    @Embedded
//    @AttributeOverrides(
//            {
//                    @AttributeOverride(name = "country", column = @Column(name = "emp_country")),
//                    @AttributeOverride(name = "city", column = @Column(name = "emp_city"))
//            }
//    )
//    private Address address;

    public Employee() {
    }

    public Employee(String name, Integer salary, Double experience, List<Friend> friends) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
        this.friends = friends;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                ", friends=" + friends +
                '}';
    }
}
