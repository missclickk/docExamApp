package com.example.exam.controller;

import com.example.exam.model.Organization;
import com.example.exam.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @PostMapping("/organization")
    public  Organization createOrganization(@RequestBody Organization org){
        return  organizationService.create(org);
    }

    @GetMapping("/organization")
    public Page<Organization> getPage(){
        System.out.println("test");
        return  organizationService.getPage(1);
    }

}
