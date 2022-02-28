package com.example.exam.spec;

import com.example.exam.model.Employee;
import com.example.exam.model.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TestSpec extends  SearchSpecification<Employee> {

}
