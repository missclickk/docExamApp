package com.example.exam.model.assignmentState;

import com.example.exam.dto.AssignmentDto;
import com.example.exam.model.AssignmentState;

public class ControlState implements  State{
    private  AssignmentContext  context;
    @Override
    public void setContext(AssignmentContext context) {
        this.context = context;
    }

    @Override
    public void accept(AssignmentDto dto) {
        State state = new AcceptingState();
        this.context.setState(state);
        dto.setSignOfControl(false);
        dto.setState(new AssignmentState(56L,"accepting",null));
    }

    @Override
    public void decline(AssignmentDto dto) {
        State state = new FinalizationState();
        context.setState(state);
        dto.setSignOfControl(false);
        dto.setState(new AssignmentState(59L,"finalization",null));
    }
}
