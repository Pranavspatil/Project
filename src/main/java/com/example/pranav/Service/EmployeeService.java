package com.example.pranav.Service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.pranav.Entity.Employee;

public interface EmployeeService {

	
	
	public List<Employee> getAll();
	
	public void updateById(Integer id,Employee emp);
	
	public void add(String firstname,String lastname,String eMail);
	
	public void pdfCreation();
	
	
	
	public Employee getById(Integer empId);
}
