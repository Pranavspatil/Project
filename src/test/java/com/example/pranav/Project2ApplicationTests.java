package com.example.pranav;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.pranav.Controller.EmployeeController;
import com.example.pranav.Entity.Employee;
import com.example.pranav.Repository.EmployeeRepository;
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:/application.properties")

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class Project2ApplicationTests {
	@Autowired
	EmployeeController emp ;
	@Autowired
	Employee e;
	@Autowired
	EmployeeRepository repo;
	
//	@BeforeClass
//	public void setEmp() {
//		
//		e = new Employee();
//		emp = new EmployeeController();
//	}
//	
	
	@Test
	public void testGetBYId() {
		//given
		e.setFirstName("ramesh");
		e.setLastName("bhingeri");
		e.seteMail("ramesh@gmai.com");
		Employee employee = repo.save(e);
		
		//when
       Employee employee2 = emp.getById(employee.getId());
		
		
		assertEquals(employee.getFirstName(),employee2.getFirstName() );
		
		System.out.println(employee.getFirstName());
		System.out.println(employee2.getFirstName());
		
	}


	@Test
	void contextLoads() {
		
		
		
	}

}
