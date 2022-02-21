package com.example.exam.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Table(name = "assigment")
@Entity
public class Assignment {
    @Id
    private Long id;
    @Column(name="subject")
    private String subject;
    @Column(name="period_of_execution")
    private LocalTime periodOfExecution;
    @Column(name="text")
    private String text;
    @Column(name="sign_of_execution")
    private Boolean signOfExecution;
    @Column(name="sign_of_control")
    private Boolean signOfControl;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Employee author;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "employees_assigments",
            joinColumns = {@JoinColumn(name = "assigment_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id" )}
    )
    private List<Employee> executors;
}
