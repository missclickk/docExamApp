package com.example.exam.utils;

import com.example.exam.model.assignmentState.*;
import org.springframework.stereotype.Component;

@Component
public  class AssignmentStateFactory {

    public   State getState(String name) {
        switch (name){
            case "accepting":
                return new AcceptingState();
            case "control":
                return  new ControlState();
            case "execution":
                return  new ExecutionState();
            case "finalization":
                return  new FinalizationState();
            case "preparation":
                return  new PreparationState();
            default:
                return   new PreparationState();
        }
    }
}
