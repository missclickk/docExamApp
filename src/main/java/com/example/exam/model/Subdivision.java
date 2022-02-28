package com.example.exam.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "subdivision")
@Entity
public class Subdivision {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="contact_data", nullable = false)
    private String contactData;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "supervisor_id")
    private Employee supervisor;

    @OneToMany(mappedBy = "subdivision", cascade=CascadeType.ALL)
    private List<Employee> employees;

    public Subdivision() {
    }

    public Subdivision(Long id, String name, String contactData, Organization organization, Employee supervisor, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.contactData = contactData;
        this.organization = organization;
        this.supervisor = supervisor;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactData() {
        return contactData;
    }

    public Organization getOrganization() {
        return organization;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactData(String contactData) {
        this.contactData = contactData;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
