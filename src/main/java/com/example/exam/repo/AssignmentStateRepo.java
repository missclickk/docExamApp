package com.example.exam.repo;

import com.example.exam.model.AssignmentState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentStateRepo  extends JpaRepository<AssignmentState,Long> {
        public  AssignmentState getAssignmentStateByName(String name);
}
