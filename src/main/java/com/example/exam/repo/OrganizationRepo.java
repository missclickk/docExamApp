package com.example.exam.repo;

import com.example.exam.model.Assignment;
import com.example.exam.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepo extends  JpaRepository<Organization,Long> {
}
