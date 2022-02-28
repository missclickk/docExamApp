package com.example.exam.spec;

import com.example.exam.enums.EntityClasses;
import com.example.exam.model.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public  class SearchSpecification<T> implements Specification<T> {
    private SearchCriteria criteria;
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(root.get(criteria.getKey()).getJavaType() == String.class){
            return  criteriaBuilder.like(  root.<String>get(criteria.getKey()), "%"+criteria.getValue()+"%");
        }
        else {
            return  criteriaBuilder.equal(root.get(criteria.getKey()),criteria.getValue());
        }
    }



    public void setCriteria(SearchCriteria criteria) {
        this.criteria = criteria;
    }
}
