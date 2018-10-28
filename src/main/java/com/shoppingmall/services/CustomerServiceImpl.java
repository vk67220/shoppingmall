package com.shoppingmall.services;

import com.shoppingmall.dao.CustomerDAO;
import com.shoppingmall.entity.Customer;
import com.shoppingmall.entity.CustomerWithNumberOfOrders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author muralinutalapati
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private Logger log = LoggerFactory.getLogger(getClass().getName());
	private CustomerDAO customerDAO;

	@Autowired
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
  @Transactional(rollbackFor = Exception.class)
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Customer getCustomer(int id) {
		Customer customer = customerDAO.getCustomer(id);
		log.info("--->>> {}" , customer);
		return customer;
	}

	@Override
	public List<CustomerWithNumberOfOrders> getCustomersWithNumberOfOrders() {
		return customerDAO.getCustomersWithNumberOfOrders();
	}
}
