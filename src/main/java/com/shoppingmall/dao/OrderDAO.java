package com.shoppingmall.dao;

import com.shoppingmall.entity.Order;
import com.shoppingmall.entity.ProductOrder;

import java.util.List;

public interface OrderDAO {
  List<ProductOrder> getProducOrders();
  List<Order> getAllOrders();
}
