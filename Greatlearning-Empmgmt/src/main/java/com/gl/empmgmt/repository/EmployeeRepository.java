package com.gl.empmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.empmgmt.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
