package com.hungpt.crudbasic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hungpt.crudbasic.Model.Employee;
import com.hungpt.crudbasic.Service.IEmployee;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployee employeeService;
	
//	API add employee
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee e) {
		return employeeService.addEmployee(e);
	}
//	API update
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable("id") Integer id,@RequestBody Employee e) {
		return employeeService.updateEmployee(id, e);
	}
//	API delete 
	@DeleteMapping("/delete/{id}")
	public boolean deleteEmployee(@PathVariable("id") Integer id) {
		return employeeService.deleteEmployee(id);
	}
	
//	API insert
	@GetMapping("/list")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
}
