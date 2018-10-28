package com.shoppingmall.dao;

import com.shoppingmall.entity.Customer;
import com.shoppingmall.dto.CustomerWithNumberOfOrders;
import com.shoppingmall.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author muralinutalapati
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

  private Logger log = LoggerFactory.getLogger(getClass().getName());

  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public Customer getCustomer(int id) {
    return entityManager.find(Customer.class, id);
  }

  @Override
  @SuppressWarnings({"unchecked", "SqlNoDataSourceInspection"})
  public List<CustomerWithNumberOfOrders> getCustomersWithNumberOfOrders() {
    final List<CustomerWithNumberOfOrders> customers = new ArrayList<>();
    List<Object[]> results = entityManager.createNativeQuery(new StringBuilder()
          .append("SELECT \n")
          .append("    c.customerNumber,\n")
          .append("    c.customerName AS name,\n")
          .append("    CONCAT(c.contactFirstName,\n")
          .append("            ' ',\n")
          .append("            c.contactLastName) AS customerName,\n")
          .append("    COUNT(*) AS count\n")
          .append("FROM\n")
          .append("    customers c\n")
          .append("        LEFT JOIN\n")
          .append("    orders o ON c.customerNumber = o.customerNumber\n")
          .append("GROUP BY c.customerNumber\n")
          .append("ORDER BY count DESC;\n").toString()).getResultList();
    for (Object[] result : results) {
      CustomerWithNumberOfOrders c = new CustomerWithNumberOfOrders();
      int customerNumber = (Integer) result[0];
      int count = ((BigInteger) result[3]).intValue();
      c.setCustomerNumber(customerNumber);
      c.setName((String) result[1]);
      c.setCustomerName((String) result[2]);
      c.setCount(count);
      log.debug("object created {}", c);
      customers.add(c);
    }
    return customers;
  }
}
