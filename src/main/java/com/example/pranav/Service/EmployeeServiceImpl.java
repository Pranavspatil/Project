package com.example.pranav.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pranav.Entity.Employee;
import com.example.pranav.Repository.EmployeeRepository;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository repo;
//	private Employee emp;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repo) {
	
		this.repo = repo;
		
	}
	
	

	public EmployeeServiceImpl() {
		
	}



	@Override
	public List<Employee> getAll() {
		List<Employee> list = repo.findAll();
		return list;
	}

	@Override
	public void updateById(Integer id, Employee emp) {
		Employee employee = repo.findById(id).orElse(null);
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.seteMail(emp.geteMail());
		repo.save(employee);

	}

	@Override
	public void add(String firstname, String lastname, String eMail) {
		Employee emp =new Employee(firstname, lastname, eMail);
		
		repo.save(emp);

	}

	@Override
	public Employee getById(Integer empId) {
		Employee empl = repo.findById(empId).orElse(null);
		return empl;
	}

	@Override
	public void pdfCreation() {

		String filepath = "C:\\devgad\\pdf\\project1.pdf";

		try {
			PdfWriter writer = new PdfWriter(filepath);
			PdfDocument PdfDoc = new PdfDocument(writer);
			Document document = new Document(PdfDoc);

			float[] columnwidth = { 200f, 200f, 200f, 200f };
//			System.out.println("12345");
			Table table = new Table(columnwidth);
			table.addCell(new Cell().add("id"));
			table.addCell(new Cell().add("first_name"));
			table.addCell(new Cell().add("last_name"));
			table.addCell(new Cell().add("Email"));
//			System.out.println("22345");
			List<Employee> list = repo.findAll();

			for (Employee emp : list) {
				table.addCell(new Cell().add(Integer.toString(emp.getId())));
				table.addCell(new Cell().add(emp.getFirstName()));
				table.addCell(new Cell().add(emp.getLastName()));
				table.addCell(new Cell().add(emp.geteMail()));

			}

			document.add(table);
			 document.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
}
