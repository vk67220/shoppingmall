package com.shoppingmall.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author muralinutalapati
 */
@Entity
@Table(name = "orderdetails")
public class OrderDetails {
  @Id
  private int orderNumber;
  private String productCode;
  private int quantityOrdered;
  private BigDecimal priceEach;
  private short orderLineNumber;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "productCode", insertable=false, updatable=false, referencedColumnName = "productCode")
  private Product product;


  public OrderDetails(int orderNumber, String productCode, int quantityOrdered, BigDecimal priceEach, short orderLineNumber) {
    this.orderNumber = orderNumber;
    this.productCode = productCode;
    this.quantityOrdered = quantityOrdered;
    this.priceEach = priceEach;
    this.orderLineNumber = orderLineNumber;
  }

  public OrderDetails() {
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(int orderNumber) {
    this.orderNumber = orderNumber;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public int getQuantityOrdered() {
    return quantityOrdered;
  }

  public void setQuantityOrdered(int quantityOrdered) {
    this.quantityOrdered = quantityOrdered;
  }

  public BigDecimal getPriceEach() {
    return priceEach;
  }

  public void setPriceEach(BigDecimal priceEach) {
    this.priceEach = priceEach;
  }

  public short getOrderLineNumber() {
    return orderLineNumber;
  }

  public void setOrderLineNumber(short orderLineNumber) {
    this.orderLineNumber = orderLineNumber;
  }
}
