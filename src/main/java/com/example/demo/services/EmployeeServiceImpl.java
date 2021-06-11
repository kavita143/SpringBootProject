package com.example.demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Employee;
import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.IEmployeeDAO;
import com.example.demo.exceptions.DuplicateIdException;
import com.example.demo.exceptions.IdNotFoundException;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeDAO empDao;

	@Override
	public Employee addEmployee(Employee e) {
		return empDao.save(e);
	}

	@Override
	public boolean deleteEmployee(int empId) throws IdNotFoundException {
		Employee emp = empDao.findById(empId).orElse(null);
		if (emp == null)
			throw new IdNotFoundException("Id is not present");
		else
			empDao.delete(emp);
		return true;
	}

	@Override
	public List<Employee> displayEmployees() {

		return empDao.findAll();
	}

	@Override
	public Employee searchEmployee(int empId) throws IdNotFoundException {
		Employee emp = empDao.findById(empId).orElse(null);
		if (emp == null)
			throw new IdNotFoundException("Id is not present");
		else
			return emp;
	}

	@Override
	public Employee updateEmployee(Employee e, int empId) throws IdNotFoundException {
		Employee emp = empDao.findById(empId).orElse(null);
		if (emp == null)
			throw new IdNotFoundException("Id is not present");
		else {
			e.setEmpId(empId);
			return empDao.save(e);
		}
	}

}
