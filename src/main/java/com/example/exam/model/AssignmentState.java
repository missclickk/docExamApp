package com.example.exam.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "assignment_state")
@Entity
public class AssignmentState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(name = "name", nullable = false)
    private  String name;

    @OneToMany(mappedBy = "state")
    private List<Assignment> assignments;

    public AssignmentState() {
    }

    public AssignmentState(Long id, String name, List<Assignment> assignments) {
        this.id = id;
        this.name = name;
        this.assignments = assignments;
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

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}
