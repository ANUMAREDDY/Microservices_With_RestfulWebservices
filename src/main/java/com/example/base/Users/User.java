package com.example.base.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
@Entity(name="user_details")
public class User {
    public User() {
    }

    @Id
    @GeneratedValue
    private Integer Id;
    @Size(min=2)
    private String name;
    @Past
    private LocalDate DOB;

    public User(Integer id, String name, LocalDate DOB) {
        Id = id;
        this.name = name;
        this.DOB = DOB;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", DOB=" + DOB +
                '}';
    }
}
