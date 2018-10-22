package com.shoppingmall.dao;

import com.shoppingmall.entity.ProductOrder;

import java.util.List;

public interface OrderDAO {
  List<ProductOrder> getProducOrders();
}
