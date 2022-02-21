package com.example.exam.repo;

import com.example.exam.model.Employee;
import com.example.exam.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends  JpaRepository<Employee,Long> {
}
