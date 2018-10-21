package com.shoppingmall.controllers;

import com.shoppingmall.entity.Customer;
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

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return null;
	}
}
