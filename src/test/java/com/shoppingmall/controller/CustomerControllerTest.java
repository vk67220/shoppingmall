package com.shoppingmall.controller;

import com.shoppingmall.controllers.CustomersController;
import com.shoppingmall.entity.Customer;
import com.shoppingmall.services.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class CustomerControllerTest {

  @InjectMocks
  private CustomersController customersController;

  @Mock
  private CustomerService customerService;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testCustomers(){
    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer("murali", "murali", "Nutalapati"));
    customers.add(new Customer("bobby", "bobby", "Nutalapati"));
    customers.add(new Customer("Candy", "candy", "Nutalapati"));
    when(customerService.getCustomers()).thenReturn(customers);
    assertEquals(3, customers.size());
  }

}
