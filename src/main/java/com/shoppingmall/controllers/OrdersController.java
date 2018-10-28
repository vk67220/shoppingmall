package com.shoppingmall.controllers;

import com.shoppingmall.entity.Order;
import com.shoppingmall.dto.ProductOrder;
import com.shoppingmall.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author muraliprasanth.n
 */
@RestController
@RequestMapping("/api")
public class OrdersController {

  @Autowired
  private OrderService orderService;

  private Logger log = LoggerFactory.getLogger(getClass().getName());
  /**
   * @return list of orders with products and product details.
   */
  @GetMapping("/ordersWithProductDetails")
  public ResponseEntity<List<ProductOrder>> getOrders() {
    return new ResponseEntity<>(orderService.getProducOrders(), HttpStatus.OK);
  }

  @GetMapping("/orders")
  public ResponseEntity<List<Order>> getAllOrders() {
    return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
  }

  @GetMapping("/order/{orderId}")
  public ResponseEntity<Order> getOrder(@PathVariable int orderId) {
    Order orderAndDetails = orderService.getOrderAndDetails(orderId);
    return new ResponseEntity<>(orderAndDetails, HttpStatus.OK);
  }
}
