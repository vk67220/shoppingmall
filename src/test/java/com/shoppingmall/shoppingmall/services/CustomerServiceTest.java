package com.shoppingmall.shoppingmall.services;

import com.shoppingmall.dao.CustomerDAO;
import com.shoppingmall.entity.Customer;
import com.shoppingmall.services.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerDAO customerDAO;

	@Test
	public void test_getCustomerByIdService() {
		Customer customer = new Customer();
		customer.setId(141);
		customer.setFirstName("bobby");
		Mockito.when(customerDAO.getCustomer(141)).thenReturn(customer);

		Customer customer1 = customerService.getCustomer(141);

		Assert.assertEquals("both objects should be equal", customer, customer1);
	}
}
