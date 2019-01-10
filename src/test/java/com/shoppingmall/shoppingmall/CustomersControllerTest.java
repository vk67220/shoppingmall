package com.shoppingmall.shoppingmall;

import com.shoppingmall.controllers.CustomersController;
import com.shoppingmall.entity.Customer;
import com.shoppingmall.services.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomersControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@MockBean
	private CustomerService customerService;

	@Mock
	private CustomersController customersController;

	@Test
	public void testCustomerEndpoint() throws Exception {
		Customer customer = new Customer();
		customer.setFirstName("bobby");
		when(customerService.getCustomer(141)).thenReturn(customer);
		ResponseEntity<String> customerResponseEntity =
					testRestTemplate.getForEntity("/api/customers/141", String.class);
		Assert.assertEquals(200, customerResponseEntity.getStatusCodeValue());
		Assert.assertEquals(true, customerResponseEntity.getBody().contains("bobby"));
	}
}
