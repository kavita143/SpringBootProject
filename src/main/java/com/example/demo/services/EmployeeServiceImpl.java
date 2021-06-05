package com.example.demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Employee;
import com.example.demo.dao.EmployeeDAO;
import com.example.demo.exceptions.DuplicateIdException;
import com.example.demo.exceptions.IdNotFoundException;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeDAO dao;

	@Override
	public Employee addEmployee(Employee e) throws DuplicateIdException {
		return dao.addEmployee(e);
	}

	@Override
	public boolean deleteEmployee(int empId) throws IdNotFoundException {
		return dao.deleteEmployee(empId);
	}

	public List<Employee> displayEmployees() {
		return dao.getEmployees();
	}

	@Override
	public Employee searchEmployee(int empId) throws IdNotFoundException {
		return dao.searchEmployee(empId);
	}

	@Override
	public Employee updateEmployee(Employee e, int empId) throws DuplicateIdException {
		// TODO Auto-generated method stub
		
		return dao.updateEmployeeDetails(e,empId);
	}

}
