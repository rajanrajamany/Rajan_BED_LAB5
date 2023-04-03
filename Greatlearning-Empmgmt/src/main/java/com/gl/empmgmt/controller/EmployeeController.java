package com.gl.empmgmt.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.empmgmt.entity.Employee;
import com.gl.empmgmt.service.EmployeeService;

@Controller
//@RequestMapping("employees")
public class EmployeeController {

	EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/home")
	public String showHome(Model model) {
		model.addAttribute("date", new Date());
		return "home";
	}

	@GetMapping("/employees")
	public String showEmpList(Model model) {
		model.addAttribute("emps", employeeService.getAllEmployee());
		return "employee-list";

	}

	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/new")
	public String addEmployee(Model model) {

		Employee employee = new Employee();
		model.addAttribute("emps", employee);
		return "add-employee";
		// return "home";
	}

	@GetMapping("/employees/{id}")
	public String deleteemployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}

	@GetMapping("/employees/edit/{id}")
	public String editemployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit-employee";
	}

	@PostMapping("/employees/{id}")
	public String updateemployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model) {

		// get employee from database by id

		Employee existingEmployee = employeeService.getEmployeeById(id);
		// existingEmployee.se .setId(id);
		existingEmployee.setEmpFirstName(employee.getEmpFirstName());
		existingEmployee.setEmpLastName(employee.getEmpLastName());
		existingEmployee.setEmpEmail(employee.getEmpEmail());

		// save updated employee object
		employeeService.updateEmployee(existingEmployee);

		return "redirect:/employees";
	}

}
