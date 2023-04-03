package com.gl.empmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.empmgmt.entity.Employee;

@Service
public interface EmployeeService {

	public List<Employee> getAllEmployee();

	public Employee updateEmployee(Employee employee);

	public Employee saveEmployee(Employee employee);

	public void deleteEmployee(Long id);

	Employee getEmployeeById(Long id);

}
