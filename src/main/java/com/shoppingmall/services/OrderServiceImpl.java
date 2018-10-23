package com.shoppingmall.services;

import com.shoppingmall.dao.OrderDAO;
import com.shoppingmall.entity.Order;
import com.shoppingmall.entity.ProductOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
