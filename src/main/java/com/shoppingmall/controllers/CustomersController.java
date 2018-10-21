package com.shoppingmall.controllers;

import com.shoppingmall.entity.Customer;
import com.shoppingmall.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author muralinutalapati
 */
@RestController
@RequestMapping("/api")
public class CustomersController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> customers = customerService.getCustomers();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
}
