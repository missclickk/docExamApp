package com.example.exam.controller;
import com.example.exam.dto.OrganizationDto;
import com.example.exam.dto.PageDto;
import com.example.exam.model.Organization;
import com.example.exam.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/organization")
    public void   createOrganization(@RequestBody OrganizationDto org){organizationService.create(org);}

    @GetMapping("/organization")
    public List<Organization> getAll(){
        return  organizationService.getAll();
    }

    @GetMapping("/organization/{page}")
    public PageDto getPage(@PathVariable int page, @RequestParam(required = false) Map<String,String> params){
        if(!params.isEmpty()){
            var sortParam = params.getOrDefault("sortParam","id");
            Sort.Direction direction = Sort.Direction.valueOf(params.getOrDefault("direction", "DESC"));
            params.remove("direction");
            params.remove("sortParam");
            return  organizationService.getPage(page, sortParam, direction, params);
        }
        else
            return  organizationService.getPage(page);
    }

    @PatchMapping("/organization")
    public  void updateOrganization( @RequestBody OrganizationDto org ){
        organizationService.update(org);
    }

    @DeleteMapping("/organization/{id}")
    public  void deleteOrganization( @PathVariable long id  ){
        organizationService.delete(id);
    }

}
