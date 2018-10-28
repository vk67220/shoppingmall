package com.shoppingmall.dao;

import com.shoppingmall.entity.Order;
import com.shoppingmall.dto.ProductOrder;
import com.shoppingmall.repositories.OrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author muraliprasanth.n
 */
@Repository
public class OrderDAOImpl implements OrderDAO {

  private Logger log = LoggerFactory.getLogger(getClass().getName());

  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private OrdersRepository ordersRepository;

  @SuppressWarnings("unchecked")
  @Override
  public List<ProductOrder> getProducOrders() {
    Stream<ProductOrder> results = entityManager
          .createQuery(new StringBuilder()
                .append("select ")
                .append("new com.shoppingmall.dto.ProductOrder(o.orderNumber, o.orderDate, od.productCode, p.productName, p.buyPrice)")
                .append(" from Order as o inner join o.orderDetails as od inner join od.product as p")
                .toString()).getResultList().stream().skip(0).limit(20);
    List<ProductOrder> orders = results.collect(Collectors.toList());
    log.debug("===>><<?? {}", results);
    return orders;
  }

  @Override
  public List<Order> getAllOrders() {
    return ordersRepository.findAll();
  }

  @Override
  public Order getOrderAndDetails(int orderId) {
    Query query = entityManager.createQuery("from Order o join fetch o.customer where orderNumber=:id");
    query.setParameter("id", orderId);
    Order resultList = (Order) query.getSingleResult();
    return resultList;
  }

}
