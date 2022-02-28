
package com.example.exam.dto;

import com.example.exam.enums.AssigmentAction;
import com.example.exam.model.Assignment;
import com.example.exam.model.AssignmentState;
import com.example.exam.model.Employee;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class AssignmentDto implements  EntityDto {
    private Long id;
    private String subject;
    private Date periodOfExecution;
    private String text;
    private Boolean signOfExecution;
    private Boolean signOfControl;
    private Long authorId;
    private List<Long> executorsId;
    private AssigmentAction action;
    public Long getId() {
        return id;
    }
    public AssignmentState state;

    public AssignmentDto() {
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

    public Long getAuthor() {
        return authorId;
    }

    public void setAuthor(Long authorId) {
        this.authorId = authorId;
    }

    public List<Long> getExecutorsId() {
        return executorsId;
    }

    public void setExecutorId(List<Long> executorId) {
        this.executorsId = executorId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public AssigmentAction getAction() {
        return action;
    }

    public void setAction(AssigmentAction action) {
        this.action = action;
    }

    public AssignmentState getState() {
        return state;
    }

    public void setState(AssignmentState state) {
        this.state = state;
    }
}
