package com.example.exam.controller;

import com.example.exam.model.Position;
import com.example.exam.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/position")
    public List<Position> getAll(){
        return  positionService.getAll();
    }


}
