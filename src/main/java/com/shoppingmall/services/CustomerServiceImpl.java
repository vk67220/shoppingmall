package com.shoppingmall.services;

import com.shoppingmall.dao.CustomerDAO;
import com.shoppingmall.entity.Customer;
import com.shoppingmall.dto.CustomerWithNumberOfOrders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Customer getCustomer(int id) {
		Customer customer = customerDAO.getCustomer(id);
		log.info("--->>> {}" , customer);
		return customer;
	}

	@Override
	public List<CustomerWithNumberOfOrders> getCustomersWithNumberOfOrders() {
		return customerDAO.getCustomersWithNumberOfOrders();
	}

	@Override
	@Transactional
	public Page<Customer> getCustomers(Pageable pageable) {
		return customerDAO.getCustomers(pageable);
	}

}
