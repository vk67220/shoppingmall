package com.shoppingmall.repositories;

import com.shoppingmall.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author muralinutalapati
 */
public interface OrdersRepository extends JpaRepository<Order, Integer> {
}
