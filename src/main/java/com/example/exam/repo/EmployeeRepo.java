package com.example.exam.repo;

import com.example.exam.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
        @Query("select  o from Employee  o where o.id in :ids")
      List<Employee> findByIds(@Param("ids") List<Long> idList);

}
