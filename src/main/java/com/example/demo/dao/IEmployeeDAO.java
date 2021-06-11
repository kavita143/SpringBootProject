package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Employee;

@Repository
public interface IEmployeeDAO extends JpaRepository<Employee, Integer>{

}
