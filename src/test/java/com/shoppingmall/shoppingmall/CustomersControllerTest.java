package com.shoppingmall.shoppingmall;

import com.shoppingmall.controllers.CustomersController;
import com.shoppingmall.entity.Customer;
import com.shoppingmall.services.CustomerService;
import com.shoppingmall.services.CustomerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class CustomersControllerTest {

  private MockMvc mockMvc;

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
  public void testCustomers() throws Exception {
    mockMvc.perform(
          get("/api/customers")
    ).andExpect(status().isOk());
  }

  @Test
  public void testCustomersWithId() throws Exception {
    when(customerService.getCustomer(141)).thenReturn(customer);
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
          "/api/customers/141").accept(
          MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
  }


}
