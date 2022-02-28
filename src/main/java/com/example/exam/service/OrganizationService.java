package com.example.exam.service;

import com.example.exam.dto.OrganizationDto;
import com.example.exam.dto.PageDto;
import com.example.exam.model.Employee;
import com.example.exam.model.Organization;
import com.example.exam.model.Position;
import com.example.exam.repo.OrganizationRepo;
import com.example.exam.repo.PositionRepo;
import com.example.exam.spec.OrganizationSpecification;
import com.example.exam.utils.SearchFacotory;
import org.aspectj.weaver.ast.Or;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.nio.file.LinkOption;
import java.util.List;
import java.util.Map;

@Service
public class OrganizationService extends  EntityService<OrganizationSpecification,OrganizationDto,Organization,OrganizationRepo> {
    @Autowired
    private PositionRepo postionRepo;

    @Autowired
    public OrganizationService(OrganizationRepo repo) {
        super(repo, Organization.class, OrganizationDto.class,OrganizationSpecification.class);
    }

    @Override
    public Organization create(OrganizationDto dto){
        var position =  postionRepo.getById(dto.getSupervisor().getPosition().getId());
        dto.getSupervisor().setPosition(position);
        return super.create(dto);
    }

    @Override
    protected void nullifyCicle(List<Organization> page){
        page.stream().forEach(el ->{
            var pos = el.getSupervisor().getPosition();
            Position nPos = new Position( pos == null ? null :  pos.getId(), pos == null ? null : pos.getName());
            el.getSupervisor().setPosition(nPos);
        });
    }

}
