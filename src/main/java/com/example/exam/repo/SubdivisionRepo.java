package com.example.exam.repo;

import com.example.exam.model.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SubdivisionRepo extends JpaRepository<Subdivision, Long>, JpaSpecificationExecutor<Subdivision> {
}
