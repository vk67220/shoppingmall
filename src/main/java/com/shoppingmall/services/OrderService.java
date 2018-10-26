package com.shoppingmall.services;

import com.shoppingmall.entity.Order;
import com.shoppingmall.entity.ProductOrder;
import java.util.List;

/**
 * @author muraliprasanth.n
 */
public interface OrderService {
  List<ProductOrder> getProducOrders();
  List<Order> getAllOrders();
  Order getOrderAndDetails(int orderId);
}
