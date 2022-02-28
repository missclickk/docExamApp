package com.example.exam.model.assignmentState;

import com.example.exam.dto.AssignmentDto;
import com.example.exam.exception.InvalidActionFotState;
import com.example.exam.model.AssignmentState;

public class PreparationState  implements  State{
    private AssignmentContext context;

    @Override
    public void setContext(AssignmentContext context) {
        this.context = context;
    }

    @Override
    public void accept(AssignmentDto dto) {
        State state = new ExecutionState();
        context.setState(state);
        dto.setSignOfExecution(true);
        dto.setState(new AssignmentState(58L,"executing",null));
    }

    @Override
    public void decline(AssignmentDto dto) {
    }
}
