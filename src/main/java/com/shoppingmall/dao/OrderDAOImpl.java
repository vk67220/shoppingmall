package com.shoppingmall.dao;

import com.shoppingmall.entity.ProductOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

  @SuppressWarnings("unchecked")
  @Override
  public List<ProductOrder> getProducOrders() {
    Stream<ProductOrder> results = entityManager
          .createQuery(new StringBuilder()
                .append("select ")
                .append("new com.shoppingmall.entity.ProductOrder(o.orderNumber, o.orderDate, od.productCode, p.productName, p.buyPrice)")
                .append(" from Order as o inner join o.orderDetails as od inner join od.product as p")
                .toString()).getResultList().stream().skip(0).limit(20);
    List<ProductOrder> orders = results.collect(Collectors.toList());
    log.debug("===>><<?? {}", results);
    return orders;
  }
}
