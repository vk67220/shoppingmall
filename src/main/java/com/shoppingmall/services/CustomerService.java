package com.shoppingmall.services;

import com.shoppingmall.entity.Customer;

import java.util.List;

public interface CustomerService {
	List<Customer> getCustomers();
	Customer getCustomer(int id);
}
