package com.example.exam.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class EntityService<T, R extends JpaRepository<T,Long>> {
    protected  R repo;
    protected  int pageSize = 10;

    public EntityService(R repo) {
        this.repo = repo;
    }
    public Page<T> getPage(int page){
        return  repo.findAll(PageRequest.of( page , pageSize ));
    }
}
