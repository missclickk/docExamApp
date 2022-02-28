package com.example.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Table(name = "position")
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    private List<Employee> employees;

    public Position() {
    }

    public Position(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Position(Long id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;

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


    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
