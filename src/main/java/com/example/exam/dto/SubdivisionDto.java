package com.example.exam.dto;

import com.example.exam.model.Employee;
import com.example.exam.model.Organization;

import javax.persistence.*;
import java.util.List;

public class SubdivisionDto implements  EntityDto {

    private Long id;
    private String name;
    private String contactData;
    private Long organizationId;
    private Employee supervisor;
    private List<Employee> employees;

    public SubdivisionDto() {
    }

    public SubdivisionDto(Long id, String name, String contactData, Long organizationId, Employee supervisor, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.contactData = contactData;
        this.organizationId = organizationId;
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

    public Long getOrganizationId() {
        return organizationId;
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

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
