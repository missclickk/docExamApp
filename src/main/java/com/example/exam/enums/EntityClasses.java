package com.example.exam.enums;

import com.example.exam.model.Assignment;
import com.example.exam.model.Employee;
import com.example.exam.model.Organization;
import com.example.exam.model.Subdivision;

public enum EntityClasses {
    organization(Organization.class),
    employee( Employee.class),
    subdivision( Subdivision.class),
    assigment(Assignment.class);


    private Class enityClass;

    EntityClasses( Class enityClass) {
    }

    public Class getEnityClass() {
        return enityClass;
    }
}
