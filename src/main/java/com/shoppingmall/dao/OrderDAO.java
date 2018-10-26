package com.shoppingmall.dao;

import com.shoppingmall.entity.Order;
import com.shoppingmall.entity.ProductOrder;

import java.util.List;
import java.util.Optional;

public interface OrderDAO {
  List<ProductOrder> getProducOrders();
  List<Order> getAllOrders();
  Order getOrderAndDetails(int orderId);
}
