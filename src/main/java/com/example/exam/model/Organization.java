package com.example.exam.model;


import javax.persistence.*;
import java.util.List;

@Table(name = "organization")
@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="physical_adress", nullable = false)
    private String physicalAdress;
    @Column(name="legalAddress", nullable = false)
    private String legalAddress;

    @OneToOne(fetch = FetchType.EAGER , cascade=CascadeType.ALL )
    @JoinColumn(name = "supervisor_id")
    private Employee supervisor;

    @OneToMany(mappedBy = "organization", cascade=CascadeType.MERGE)
    private List<Subdivision> subdivisions;

    public Organization() {
    }

    public Organization(Long id, String name, String physicalAdress, String legalAddress, Employee supervisor) {
        this.id = id;
        this.name = name;
        this.physicalAdress = physicalAdress;
        this.legalAddress = legalAddress;
        this.supervisor = supervisor;
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

    public String getPhysicalAdress() {
        return physicalAdress;
    }

    public void setPhysicalAdress(String physicalAdress) {
        this.physicalAdress = physicalAdress;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public void setLegalAddress(String legalAddress) {
        this.legalAddress = legalAddress;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }
}
