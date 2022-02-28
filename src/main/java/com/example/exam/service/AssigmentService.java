package com.example.exam.service;

import com.example.exam.dto.AssignmentDto;
import com.example.exam.dto.PageDto;
import com.example.exam.enums.AssigmentAction;
import com.example.exam.model.Assignment;
import com.example.exam.model.Position;
import com.example.exam.model.Subdivision;
import com.example.exam.model.assignmentState.AssignmentContext;
import com.example.exam.repo.AssignmentRepo;
import com.example.exam.repo.AssignmentStateRepo;
import com.example.exam.repo.EmployeeRepo;
import com.example.exam.spec.AssignmentSpecification;
import com.example.exam.utils.AssignmentStateFactory;
import com.example.exam.utils.SearchFacotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;

@Service
public class AssigmentService extends  EntityService<AssignmentSpecification,AssignmentDto, Assignment, AssignmentRepo> {
    @Autowired
    AssignmentStateRepo stateRepo;
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    AssignmentStateFactory stateFactory;

    @Autowired
    public AssigmentService(AssignmentRepo repo) {
        super(repo, Assignment.class , AssignmentDto.class, AssignmentSpecification.class);
    }

    @Override
    public  Assignment create(AssignmentDto dto){
        dto.setState( stateRepo.getAssignmentStateByName("preparation") );
        var assignment =  super.create(dto);
        var emls = employeeRepo.findByIds(dto.getExecutorsId());
        emls.stream().forEach(el->{
            var list = el.getAssignmentList();
            list.add(assignment);
            el.setAssignmentList(list);
            employeeRepo.save(el);
        });
        return  assignment;
    }

    @Override
    public  void update(AssignmentDto dto){
        mapper.getConfiguration().setSkipNullEnabled(true);
        Assignment entity = repo.findById(dto.getId())
                .orElseThrow(()-> new EntityNotFoundException("assigmnet с id "+dto.getId()+" не найден"));
        AssignmentContext context = new AssignmentContext(stateFactory.getState(entity.getState().getName()));
        if(dto.getAction() == AssigmentAction.ACCEPT)
            context.accept(dto);
        if(dto.getAction() == AssigmentAction.DECLINE)
            context.decline(dto);
        mapper.map(dto,entity);
        repo.save(entity);
    }

    @Override
    protected void nullifyCicle(List<Assignment> page) {
        page.stream().forEach(el -> {
            var pos = el.getAuthor().getPosition() ;
            Position nPos =  pos != null ? new Position(pos.getId(),pos.getName()) : null;
            el.getAuthor().setPosition(nPos);
            el.getAuthor().setSubdivision(null);
            el.getAuthor().setAssignmentList(null);
            el.getState().setAssignments(null);
            el.getExecutors().stream().forEach(exec ->{
                var ePos = exec.getPosition().getEmployees() == null ? new Position() : exec.getPosition();
                var enPos = new Position( ePos.getId(),ePos.getName());
                exec.setPosition(enPos);
                exec.setSubdivision(null);
                exec.setAssignmentList(null);
            });
        });
    }

}
