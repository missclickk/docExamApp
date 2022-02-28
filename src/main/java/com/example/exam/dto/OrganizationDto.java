package com.example.exam.dto;

import com.example.exam.model.Employee;
import com.example.exam.model.Subdivision;

import javax.persistence.*;
import java.util.List;

public class OrganizationDto implements EntityDto {
    private Long id;
    private String name;
    private String physicalAdress;
    private String legalAddress;
    private Employee supervisor;
    private List<Subdivision> subdivisions;

    public OrganizationDto() {
    }

    public OrganizationDto(Long id, String name, String physicalAdress, String legalAddress, Employee supervisor) {
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
