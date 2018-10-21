package com.shoppingmall.services;

import com.shoppingmall.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
	List<Customer> getCustomers();
}
