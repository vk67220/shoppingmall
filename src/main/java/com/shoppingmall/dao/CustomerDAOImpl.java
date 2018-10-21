package com.shoppingmall.dao;

import com.shoppingmall.entity.Customer;
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
		return (List<Customer>)theQuery.getResultList();
	}
}
