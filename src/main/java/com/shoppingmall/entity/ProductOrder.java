package com.shoppingmall.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author muraliprasanth.n
 */
public class ProductOrder {
  private int orderNumber;
  private Date orderDate;
  private String productCode;
  private String productName;
  private BigDecimal buyPrice;

  public ProductOrder(int orderNumber, Date orderDate, String productCode, String productName, BigDecimal buyPrice) {
    this.orderNumber = orderNumber;
    this.orderDate = orderDate;
    this.productCode = productCode;
    this.productName = productName;
    this.buyPrice = buyPrice;
  }

  public int getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(int orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public BigDecimal getBuyPrice() {
    return buyPrice;
  }

  public void setBuyPrice(BigDecimal buyPrice) {
    this.buyPrice = buyPrice;
  }
}
