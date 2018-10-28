package com.shoppingmall.services;

import com.shoppingmall.dao.OrderDAO;
import com.shoppingmall.entity.Order;
import com.shoppingmall.dto.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author muraliprasanth.n
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class OrderServiceImpl implements  OrderService{

  @Autowired
  private OrderDAO orderDAO;

  @Override
  public List<ProductOrder> getProducOrders() {
    return orderDAO.getProducOrders();
  }

  @Override
  public List<Order> getAllOrders() {
    return orderDAO.getAllOrders();
  }

  @Override
  public Order getOrderAndDetails(int orderId) {
    return orderDAO.getOrderAndDetails(orderId);
  }
}
