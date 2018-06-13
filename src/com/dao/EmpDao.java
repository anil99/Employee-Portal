package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.model.Employee;
import com.service.EmpService;

@Repository
public class EmpDao {
private static List<Employee> list = null;
	


	
	public List<Employee> getUserList() {
		return list;
	}
	
	public void addEmployee(Employee employeeService) {
		list.add(employeeService);
	}

	 public void saveOrUpdate(Employee employee) {
	        // implementation details goes here...
	    }
	 
	   
	    public void delete(int contactId) {
	        // implementation details goes here...
	    }
	 
	/*
	    public List<Employee> list() {
	        // implementation details goes here...
	    }
	 
	   /* 
	    public Employee get(int contactId) {
	        // implementation details goes here...
	    }
	
	*/
}