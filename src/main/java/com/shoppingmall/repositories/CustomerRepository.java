package com.shoppingmall.repositories;

import com.shoppingmall.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author muralinutalapati
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
