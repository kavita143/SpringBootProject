package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Employee;
import com.example.demo.beans.ResponseMessage;
import com.example.demo.exceptions.DuplicateIdException;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.services.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@RequestMapping(method = RequestMethod.GET, value = "/getEmployees")
	public ResponseEntity<List<Employee>> displayEmployees() {
		return new ResponseEntity<List<Employee>>(service.displayEmployees(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getEmployee/{empId}")
	public ResponseEntity<Employee> searchEmployee(@PathVariable int empId) throws IdNotFoundException {
		return new ResponseEntity<Employee>(service.searchEmployee(empId), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) throws DuplicateIdException {
		return new ResponseEntity<Employee>(service.addEmployee(e), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteEmployee/{empId}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable int empId) throws IdNotFoundException {
		return new ResponseEntity<Boolean>(service.deleteEmployee(empId), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateEmployee/{empId}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e, @PathVariable int empId)
			throws IdNotFoundException {
		return new ResponseEntity<Employee>(service.updateEmployee(e, empId), HttpStatus.OK);

	}

	

}
