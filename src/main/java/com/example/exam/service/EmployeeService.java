package com.example.exam.service;

import com.example.exam.dto.EmployeeDto;
import com.example.exam.dto.PageDto;
import com.example.exam.model.Employee;
import com.example.exam.model.Organization;
import com.example.exam.model.Position;
import com.example.exam.repo.EmployeeRepo;
import com.example.exam.spec.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service

public class EmployeeService extends  EntityService<EmployeeSpecification,EmployeeDto ,Employee, EmployeeRepo> {

    @Autowired
    public EmployeeService(EmployeeRepo repo) {
        super(repo, Employee.class, EmployeeDto.class, EmployeeSpecification.class);
    }

    @Override
    protected void nullifyCicle(List<Employee> page){
        page.stream().forEach(el ->{
            var pos = el.getPosition();
            Position nPos = new Position( pos == null ? null :  pos.getId(), pos == null ? null : pos.getName());
            el.setPosition(nPos);
            if(el.getSubdivision() != null) {
                el.getSubdivision().getOrganization().setSupervisor(null);
                el.getSubdivision().setSupervisor(null);
                el.getSubdivision().setEmployees(null);
            }
            if(el.getAssignmentList() != null)
                el.setAssignmentList(null);
        });
    }

}
