package com.example.demo.services;

import java.util.List;

import com.example.demo.beans.Employee;
import com.example.demo.exceptions.DuplicateIdException;
import com.example.demo.exceptions.IdNotFoundException;
public interface IEmployeeService {

	public Employee  addEmployee(Employee e) throws DuplicateIdException;
	public Employee  updateEmployee(Employee e,int empId) throws DuplicateIdException;
	public boolean deleteEmployee(int empId) throws  IdNotFoundException;
	public List<Employee> displayEmployees();
	public Employee searchEmployee(int empId) throws IdNotFoundException;
	
}
