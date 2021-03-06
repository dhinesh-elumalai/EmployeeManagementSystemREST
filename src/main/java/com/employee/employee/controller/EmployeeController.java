package com.employee.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.dto.EmployeeDto;
import com.employee.employee.entity.Employee;
import com.employee.employee.exception.EmployeeMgmtException;
import com.employee.employee.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {


	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getEmployees() throws EmployeeMgmtException {
		
		List<Employee> empList = empService.getAllEmployees();
		
		return new ResponseEntity<>(empList , HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmp(@RequestBody EmployeeDto employeeDto) {
		
		Employee savedEmployee = empService.saveEmployee(employeeDto);
		
		return new ResponseEntity<>(savedEmployee , HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable("id") Integer id, Model model) throws EmployeeMgmtException {
		
		String message = empService.deleteEmployeeById(id);
		
		return new ResponseEntity<>(message , HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmp(@RequestBody EmployeeDto employeeDto) {
		
		Employee saveEmployee = empService.saveEmployee(employeeDto);
		
		return new ResponseEntity<>(saveEmployee , HttpStatus.ACCEPTED);
		
	}
	
}
