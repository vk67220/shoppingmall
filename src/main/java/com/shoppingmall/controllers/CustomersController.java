package com.shoppingmall.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingmall.entity.Customer;
import com.shoppingmall.entity.CustomerWithNumberOfOrders;
import com.shoppingmall.entity.Order;
import com.shoppingmall.exception.CustomerNotFoundException;
import com.shoppingmall.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author muralinutalapati
 */
@RestController
@RequestMapping("/api")
public class CustomersController {

  private Logger log = LoggerFactory.getLogger(getClass().getName());

  @Autowired
  private CustomerService customerService;

  /**
   * @return list of customers
   */
  @GetMapping("/customers")
  public ResponseEntity<List<Customer>> getCustomers() {
    List<Customer> customers = customerService.getCustomers();
    return new ResponseEntity<>(customers, HttpStatus.OK);
  }


  /**
   * @param id
   * @return get customer by id and the orders.
   */
  @GetMapping("/customers/{id}")
  public ResponseEntity<Map<String, Object>> getCustomers(@PathVariable int id) {
    ObjectMapper objectMapper = new ObjectMapper();
    Customer customer = customerService.getCustomer(id);
    if (customer == null) {
      throw new CustomerNotFoundException("customer with id - " + id + " not found");
    }
    List<Order> orders = customer.getOrders();
    Map map = objectMapper.convertValue(customer, Map.class);
    map.put("orders", orders);
    log.info("map produced --> {}", map);
    return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
  }

  @GetMapping("/customers/maxOrders")
  public List<CustomerWithNumberOfOrders> getCustomersWithHighestOrders() {
    return customerService.getCustomersWithNumberOfOrders();
  }
}
