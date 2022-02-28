package com.example.exam.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Table(name = "assigment")
@Entity
public class Assignment  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="subject", nullable = false)
    private String subject;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="period_of_execution", nullable = false)
    private Date periodOfExecution;
    @Column(name="text")
    private String text;
    @Column(name="sign_of_execution")
    private Boolean signOfExecution;
    @Column(name="sign_of_control")
    private Boolean signOfControl;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private AssignmentState state;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Employee author;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "employees_assigments",
            joinColumns = {@JoinColumn(name = "assigment_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id" )}
    )
    private List<Employee> executors;

    public Assignment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getPeriodOfExecution() {
        return periodOfExecution;
    }

    public void setPeriodOfExecution(Date periodOfExecution) {
        this.periodOfExecution = periodOfExecution;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getSignOfExecution() {
        return signOfExecution;
    }

    public void setSignOfExecution(Boolean signOfExecution) {
        this.signOfExecution = signOfExecution;
    }

    public Boolean getSignOfControl() {
        return signOfControl;
    }

    public void setSignOfControl(Boolean signOfControl) {
        this.signOfControl = signOfControl;
    }

    public Employee getAuthor() {
        return author;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }

    public List<Employee> getExecutors() {
        return executors;
    }

    public void setExecutors(List<Employee> executors) {
        this.executors = executors;
    }

    public AssignmentState getState() {
        return state;
    }

    public void setState(AssignmentState state) {
        this.state = state;
    }
}
