package com.example.exam.repo;

import com.example.exam.model.Assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment, Long>, JpaSpecificationExecutor<Assignment> {
}