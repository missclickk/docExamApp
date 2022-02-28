package com.example.exam.service;

import com.example.exam.dto.EntityDto;
import com.example.exam.dto.PageDto;
import com.example.exam.spec.SearchSpecification;
import com.example.exam.utils.SearchFacotory;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.Subquery;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class EntityService<S extends SearchSpecification<T>,  D extends EntityDto, T, R extends JpaRepository<T, Long> & JpaSpecificationExecutor<T>>
        {
    protected ModelMapper mapper = new ModelMapper();
    private  Class<T> modelClass;
    private  Class<D> dtoClass;
    private  Class<S> specClass;
    protected  R repo;
    protected  int pageSize = 10;
    protected  abstract void nullifyCicle(List<T> items);

    public EntityService(R repo, Class<T> modelClass, Class<D> dtoClass, Class<S> specClass) {
        this.specClass = specClass;
        this.repo = repo;
        this.modelClass = modelClass;
        this.dtoClass = dtoClass;
    }

    public PageDto getPage(int page, String sortParam , Sort.Direction direction  , Map<String,String> searchParams ){
        var searchSpec =  new SearchFacotory<T,S>().buildSearch(searchParams, specClass);
        Page req;
        if(searchSpec == null)
            req = repo.findAll(PageRequest.of( page , 10 ).withSort(direction,sortParam));
        else
            req = repo.findAll(searchSpec ,PageRequest.of( page , 10 ).withSort(direction,sortParam));
        var pageDto =  new PageDto(req.getTotalElements(), req.getContent(),pageSize, req.getTotalPages(), page);
        nullifyCicle(pageDto.getContent());
        return  pageDto;
    }


    public PageDto getPage(int page){
        var res =  repo.findAll(PageRequest.of( page , 10 ));;
        var pageDto = new PageDto(res.getTotalElements(), res.getContent(), pageSize, res.getTotalPages(), page);
        nullifyCicle(pageDto.getContent());
        return  pageDto;
    }

    public T create(D dto){
        return repo.save(mapper.map(dto, modelClass));
    }

    public  void update(D dto){
        mapper.getConfiguration().setSkipNullEnabled(true);
        var entity = repo.findById(dto.getId())
                .orElseThrow(()-> new EntityNotFoundException("entity with id " + dto.getId()+ " не найдена"));
        mapper.map(dto,entity);
        repo.save(entity);
        mapper.getConfiguration().setSkipNullEnabled(false);
    }

    public  void delete(Long id ){
        repo.deleteById(id);
    }

    public List<T> getAll(){
        var items =   repo.findAll();
        nullifyCicle(items);
        return  items;
    }

    public List<T> getAll(Map<String,String> params){
        var searchSpec =  new SearchFacotory<T,S>().buildSearch(params, specClass);
        var items =  repo.findAll(searchSpec);
        nullifyCicle(items);
        return  items;
    }
}
