package com.shoppingmall.shoppingmall;

import com.shoppingmall.controllers.CustomersController;
import com.shoppingmall.entity.Customer;
import com.shoppingmall.services.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomersController.class)
public class CustomersControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@MockBean
	private CustomersController customersController;

	@Test
	public void testCustomerEndpoint() throws Exception {
		Customer customer = new Customer();
		customer.setFirstName("bobby");
		when(customerService.getCustomer(141)).thenReturn(customer);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/141")).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		String contentAsString = response.getContentAsString();
		Assert.assertEquals(response.getErrorMessage(), "Unauthorized");
	}
}
