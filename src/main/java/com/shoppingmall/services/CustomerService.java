package com.shoppingmall.services;

import com.shoppingmall.entity.Customer;
import com.shoppingmall.dto.CustomerWithNumberOfOrders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
	Customer getCustomer(int id);
	List<CustomerWithNumberOfOrders> getCustomersWithNumberOfOrders();
	Page<Customer> getCustomers(Pageable pageable);
}
