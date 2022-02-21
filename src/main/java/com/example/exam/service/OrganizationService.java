package com.example.exam.service;

import com.example.exam.model.Organization;
import com.example.exam.repo.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService extends  EntityService<Organization,OrganizationRepo> {

    @Autowired
    public OrganizationService(OrganizationRepo repo) {
        super(repo);
    }

    public  Organization create(Organization org){
          return repo.save(org);
    }


}
