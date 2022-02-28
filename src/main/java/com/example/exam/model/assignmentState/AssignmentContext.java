package com.example.exam.model.assignmentState;

import com.example.exam.dto.AssignmentDto;
import com.example.exam.exception.InvalidActionFotState;

public class AssignmentContext {
    private State state;

    public AssignmentContext(State initialState) {
        this.state = initialState;
        this.state.setContext(this);
    }

    public  void setState(State state){
        this.state = state;
        this.state.setContext(this);
    }

    public  void accept(AssignmentDto dto) {
        this.state.accept(dto);
    }

    public  void decline(AssignmentDto dto) {
       this.state.decline(dto);
    }

}
