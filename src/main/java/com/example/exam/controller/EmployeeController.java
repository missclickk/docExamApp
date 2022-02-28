package com.example.exam.controller;

import com.example.exam.dto.EmployeeDto;
import com.example.exam.dto.PageDto;
import com.example.exam.model.Employee;
import com.example.exam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public void creatEemployee(@RequestBody EmployeeDto employee){
        employeeService.create(employee);
    }

    @GetMapping("employee")
    public List<Employee> getAll(){
        return  employeeService.getAll();
    }

    @GetMapping("/employee/{page}")
    public PageDto getPage(@PathVariable int page, @RequestParam(required = false) Map<String,String> params){
        if(!params.isEmpty()){
            var sortParam = params.getOrDefault("sortParam","id");
            Sort.Direction direction = Sort.Direction.valueOf(params.getOrDefault("direction", "DESC"));
            params.remove("direction");
            params.remove("sortParam");
            return  employeeService.getPage(page, sortParam, direction, params);
        }
        else
            return  employeeService.getPage(page);
    }

    @PatchMapping("/employee")
    public  void updatEemployee( @RequestBody EmployeeDto employee ){
        employeeService.update(employee);
    }

    @DeleteMapping("/employee/{id}")
    public  void deleteEmployee( @PathVariable long id  ){
        employeeService.delete(id);
    }
}
