package com.hungpt.crudbasic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hungpt.crudbasic.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
