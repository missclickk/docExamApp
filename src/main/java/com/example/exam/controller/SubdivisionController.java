package com.example.exam.controller;

import com.example.exam.dto.PageDto;
import com.example.exam.dto.SubdivisionDto;
import com.example.exam.model.Subdivision;
import com.example.exam.service.SubdivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SubdivisionController {

    @Autowired
    private SubdivisionService subdivisionService;

    @PostMapping("/subdivision")
    public void createSubdivision(@RequestBody SubdivisionDto subdivision){
          subdivisionService.create(subdivision);
    }

    @GetMapping("/subdivision")
    public List<Subdivision> getAll(){
        return  this.subdivisionService.getAll();
    }

    @GetMapping("/subdivision/{page}")
    public PageDto getPage(@PathVariable int page, @RequestParam(required = false) Map<String,String> params){
        if(!params.isEmpty()){
            var sortParam = params.getOrDefault("sortParam","id");
            Sort.Direction direction = Sort.Direction.valueOf(params.getOrDefault("direction", "DESC"));
            params.remove("direction");
            params.remove("sortParam");
            return  subdivisionService.getPage(page, sortParam, direction, params);
        }
        else
            return  subdivisionService.getPage(page);
    }

    @PatchMapping("/subdivision")
    public  void updateSubdivision( @RequestBody SubdivisionDto subdivision ){
        subdivisionService.update(subdivision);
    }

    @DeleteMapping("/subdivision/{id}")
    public  void deleteSubdivision( @PathVariable long id  ){
        subdivisionService.delete(id);
    }


}
