package com.example.exam.service;

import com.example.exam.model.Position;
import com.example.exam.repo.PositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    @Autowired
    private PositionRepo positionRepo;

    public List<Position> getAll(){
        var pos = positionRepo.findAll();
        pos.stream().forEach(el -> {
            el.setEmployees(null);
        });
        return  pos;
    }


}
