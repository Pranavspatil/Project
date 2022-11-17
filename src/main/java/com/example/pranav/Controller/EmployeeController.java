package com.example.pranav.Controller;



import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pranav.Entity.Employee;
import com.example.pranav.Service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class); 
	

	private EmployeeService service;

	@Autowired
	public EmployeeController(EmployeeService service) {

		this.service = service;
	}

	
	public EmployeeController() {
		
	}


	@GetMapping("/{empId}")
	public Employee getById(Integer empId) {
		logger.info ("Employee Id get Stored ");

		return service.getById(empId);
	}
	
	@PutMapping("/{id}")
	public String updateById(@PathVariable Integer id,@RequestBody Employee emp) {
		try {
			service.updateById(id, emp);
			return "record is updated";
		} catch (Exception e) {
			
			logger.error ("Employee Id not found ");

			return "record not found";
		}
	}
	
	
	@PostMapping("/save")
	public String add(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String eMail) {
		service.add(firstname, lastname, eMail);
		return "sussecfully added";
	}

	@GetMapping("/getAll")
	public List<Employee> getAll(@PathVariable Employee emp){
		return service.getAll();
	}
	
	@GetMapping("/pdf")
	public String pdfCreation() {
		service.pdfCreation();
		return "pdf generated sussesfully";
	}
}
