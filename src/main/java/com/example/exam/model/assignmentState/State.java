package com.example.exam.model.assignmentState;

import com.example.exam.dto.AssignmentDto;
import com.example.exam.exception.InvalidActionFotState;

public interface State {
    public  void setContext(AssignmentContext context);
    public void accept(AssignmentDto dto);
    public void decline(AssignmentDto dto);

}
