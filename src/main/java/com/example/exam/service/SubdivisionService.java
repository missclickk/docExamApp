package com.example.exam.service;

import com.example.exam.dto.SubdivisionDto;
import com.example.exam.model.Position;
import com.example.exam.model.Subdivision;
import com.example.exam.repo.EmployeeRepo;
import com.example.exam.repo.SubdivisionRepo;
import com.example.exam.spec.SubdivisionSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SubdivisionService extends EntityService<SubdivisionSpecification, SubdivisionDto ,Subdivision, SubdivisionRepo> {
    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    public SubdivisionService(SubdivisionRepo repo) {
        super(repo,Subdivision.class, SubdivisionDto.class, SubdivisionSpecification.class );
    }

    @Override
    public Subdivision create(SubdivisionDto dto){
        var saved = super.create(dto);
        var supervisor = saved.getSupervisor();
        supervisor.setSubdivision(saved);
        employeeRepo.save(supervisor);
        return  saved;
    }

    @Override
    protected void nullifyCicle(List<Subdivision> page) {
        page.stream().forEach(el -> {
            var pos = el.getSupervisor().getPosition();
            Position nPos = new Position(pos.getId(), pos.getName());
            el.getOrganization().getSupervisor().setPosition(null);
            el.getSupervisor().setSubdivision(null);
            el.getSupervisor().setPosition(null);
            el.getSupervisor().setAssignmentList(null);
            el.getEmployees().stream().forEach(empl->{
                empl.setSubdivision(null);
                empl.setAssignmentList(null);
                var emplPos = empl.getPosition();
                Position nePos = new Position(pos.getId(), pos.getName());
                empl.setPosition(nePos);
            });
        });
    }
}
