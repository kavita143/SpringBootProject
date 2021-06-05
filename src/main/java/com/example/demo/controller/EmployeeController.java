package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Employee;
import com.example.demo.exceptions.DuplicateIdException;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.services.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	

	@RequestMapping(method=RequestMethod.GET,value="/getEmployees")
	public List<Employee> displayEmployees() {
		return service.displayEmployees();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getEmployee/{empId}")
	public Employee searchEmployee(@PathVariable int empId) {
		try {
			return service.searchEmployee(empId);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addEmployee")
	public Employee addEmployee(@RequestBody Employee e) {
		try {
			return service.addEmployee(e);
		} catch (DuplicateIdException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deleteEmployee/{empId}")
	public Boolean deleteEmployee(@PathVariable int empId) {
		try {
			return service.deleteEmployee(empId);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/updateEmployee/{empId}")
	public Employee updateEmployee(@RequestBody Employee e, @PathVariable int empId) {
		try {
			return service.updateEmployee(e, empId);
		} catch (DuplicateIdException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	
	
}
