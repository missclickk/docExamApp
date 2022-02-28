package com.example.exam.model.assignmentState;

import com.example.exam.dto.AssignmentDto;

public class AcceptingState implements  State{
    @Override
    public void setContext(AssignmentContext context) {
    }

    @Override
    public void accept(AssignmentDto dto) {

    }

    @Override
    public void decline(AssignmentDto dto) {

    }
}
