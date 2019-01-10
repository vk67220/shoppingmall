package com.shoppingmall.shoppingmall;

import com.shoppingmall.controllers.CustomersController;
import com.shoppingmall.entity.Customer;
import com.shoppingmall.services.CustomerServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomersIntegrationTest {

  private MockMvc mockMvc;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @InjectMocks
  private CustomersController customersController;

  @InjectMocks
  private CustomerServiceImpl customerService;

  Customer customer = new Customer("Euro+ Shopping Channel", "Diego ", "Freyre");

  @Before
  public void init() {
    mockMvc = MockMvcBuilders.standaloneSetup(customersController).build();
  }

  @Test
  public void testCustomerEndpoint() {

  }


}
