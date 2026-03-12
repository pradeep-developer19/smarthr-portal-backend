package com.pradeep.samrthrportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pradeep.samrthrportal.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment(String department);

    List<Employee> findByNameContainingIgnoreCase(String name);

}