package com.example.exam.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "lsat_name", nullable = false)
    private String lastName;
    @Column(name = "patronymic")
    private String patronymic;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "subdivision_id")
    private Subdivision subdivision;

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(
            name = "employees_assigments",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "assigment_id" )}
    )
    private List<Assignment> assignmentList;

    public Employee(Long id, String firstName, String lastName, String patronymic, Position position, Subdivision subdivision, List<Assignment> assignmentList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.position = position;
        this.subdivision = subdivision;
        this.assignmentList = assignmentList;
    }

    public Employee() {
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Subdivision getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(Subdivision subdivision) {
        this.subdivision = subdivision;
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }
}
