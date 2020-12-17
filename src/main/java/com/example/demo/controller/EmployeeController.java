package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "Welcome!";
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee e) {
		repo.save(e);
		return e;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return repo.findAll();
		
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployeebyid(@PathVariable("id") int id) { 
		return repo.findById(id);
		
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployeebyId(@PathVariable("id") int id) {
		Employee a= repo.getOne(id);
		repo.delete(a);
		return "Deleted";
	}
		
	@PutMapping("/employees")
	public Employee saveOrUpdate(@RequestBody Employee e) {
		repo.save(e);
		return e;
		
	}
}
