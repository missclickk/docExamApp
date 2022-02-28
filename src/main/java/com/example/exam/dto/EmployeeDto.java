package com.example.exam.dto;

import com.example.exam.model.Assignment;
import com.example.exam.model.Position;
import com.example.exam.model.Subdivision;
import java.util.List;

public class EmployeeDto implements  EntityDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long positionId;
    private String patronymic;
    private Long subdivisionId;
    private List<Assignment> assignmentList;
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

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getSubdivisionId() {
        return subdivisionId;
    }

    public void setSubdivisionId(Long subdivisionId) {
        this.subdivisionId = subdivisionId;
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

}
