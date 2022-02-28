package com.example.exam.controller;

import com.example.exam.dto.AssignmentDto;
import com.example.exam.dto.PageDto;
import com.example.exam.model.Assignment;
import com.example.exam.service.AssigmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AssigmentController {
    @Autowired
    AssigmentService assigmentService;

    @PostMapping("/assigment")
    public void createAssigment(@RequestBody AssignmentDto assignment){

        assigmentService.create(assignment);
    }

    @GetMapping("/assigment")
    public List<Assignment> getAll(@RequestParam(required = false) Map<String,String> params){
        if(params.isEmpty())
            return  assigmentService.getAll();
        else
            return  assigmentService.getAll(params);
    }

    @GetMapping("/assigment/{page}")
    public PageDto getPage(@PathVariable int page, @RequestParam(required = false) Map<String,String> params){
        if(!params.isEmpty()){
            var sortParam = params.getOrDefault("sortParam","id");
            Sort.Direction direction = Sort.Direction.valueOf(params.getOrDefault("direction", "DESC"));
            params.remove("direction");
            params.remove("sortParam");
            return  assigmentService.getPage(page, sortParam, direction, params);
        }
        else
            return  assigmentService.getPage(page);
    }

    @PatchMapping("/assigment")
    public  void updateAssigment( @RequestBody AssignmentDto assignment ) {
        assigmentService.update(assignment);
    }

    @DeleteMapping("/assigment/{id}")
    public  void deleteAssigment( @PathVariable long id  ){
        assigmentService.delete(id);
    }

}
