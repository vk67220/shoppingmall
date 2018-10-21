package com.shoppingmall.controllers;

import com.shoppingmall.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author muralinutalapati
 */
@RestController
@RequestMapping("/api")
public class EmployeesController {

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return null;
	}
}
