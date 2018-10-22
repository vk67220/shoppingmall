package com.shoppingmall.controllers;

import com.shoppingmall.entity.ProductOrder;
import com.shoppingmall.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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


  /**
   * @return list of orders with products and product details.
   */
  @GetMapping("/ordersWithProductDetails")
  public ResponseEntity<List<ProductOrder>> getOrders() {
    return new ResponseEntity<>(orderService.getProducOrders(), HttpStatus.OK);
  }
}
