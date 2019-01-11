package com.shoppingmall.shoppingmall.controllers;

import com.shoppingmall.controllers.CustomersController;
import com.shoppingmall.entity.Customer;
import com.shoppingmall.services.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomersController.class)
@ActiveProfiles("test")
public class CustomersRESTControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Test
	public void getCustomersWithId() throws Exception {
		Customer customer = new Customer();
		customer.setFirstName("bobby");
		when(customerService.getCustomer(141)).thenReturn(customer);

		mockMvc.perform(MockMvcRequestBuilders
					.get("/api/customers/141")
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").isNotEmpty())
					.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("bobby"));
	}
}
