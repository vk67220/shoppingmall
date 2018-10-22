package com.shoppingmall.controllers;

import com.shoppingmall.entity.Customer;
import com.shoppingmall.entity.CustomerWithNumberOfOrders;
import com.shoppingmall.exception.CustomerNotFoundException;
import com.shoppingmall.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author muralinutalapati
 */
@RestController
@RequestMapping("/api")
public class CustomersController {

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
  public ResponseEntity<Customer> getCustomers(@PathVariable int id) {
    Customer customer = customerService.getCustomer(id);
    if (customer == null) {
      throw new CustomerNotFoundException("customer with id - " + id + " not found");
    }
    return new ResponseEntity<>(customer, HttpStatus.OK);
  }

  @GetMapping("/customers/maxOrders")
  public List<CustomerWithNumberOfOrders> getCustomersWithHighestOrders() {
    return customerService.getCustomersWithNumberOfOrders();
  }
}
