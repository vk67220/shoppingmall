package com.shoppingmall.dao;

import com.shoppingmall.entity.Customer;
import com.shoppingmall.entity.CustomerWithNumberOfOrders;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author muralinutalapati
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Customer> getCustomers() {
    Query theQuery = entityManager.createQuery("from Customer");
    return (List<Customer>) theQuery.getResultList();
  }

  @Override
  public Customer getCustomer(int id) {
    return entityManager.find(Customer.class, id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<CustomerWithNumberOfOrders> getCustomersWithNumberOfOrders() {
    List<CustomerWithNumberOfOrders> results = entityManager.createNativeQuery("SELECT \n" +
          "    c.customerNumber,\n" +
          "    c.customerName AS name,\n" +
          "    CONCAT(c.contactFirstName,\n" +
          "            ' ',\n" +
          "            c.contactLastName) AS customerName,\n" +
          "    COUNT(*) AS count\n" +
          "FROM\n" +
          "    customers c\n" +
          "        LEFT JOIN\n" +
          "    orders o ON c.customerNumber = o.customerNumber\n" +
          "GROUP BY c.customerNumber\n" +
          "ORDER BY count DESC;\n").getResultList();
    return results;
  }
}
