package com.shoppingmall.dao;

import com.shoppingmall.entity.Customer;
import com.shoppingmall.dto.CustomerWithNumberOfOrders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerDAO {
	Page<Customer> getCustomers(Pageable pageable);
	Customer getCustomer(int id);
  List<CustomerWithNumberOfOrders> getCustomersWithNumberOfOrders();
}
