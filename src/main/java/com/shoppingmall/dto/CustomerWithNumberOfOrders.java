package com.shoppingmall.dto;

import java.math.BigInteger;

/**
 * @author muralinutalapati
 */
public class CustomerWithNumberOfOrders {
  private int customerNumber;
  private String name;
  private String customerName;
  private int count;

  public CustomerWithNumberOfOrders(int customerNumber, String name, String customerName, int count) {
    this.customerNumber = customerNumber;
    this.name = name;
    this.customerName = customerName;
    this.count = count;
  }

  public CustomerWithNumberOfOrders() {}

  public int getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(int customerNumber) {
    this.customerNumber = customerNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  @Override
  public String toString() {
    return "CustomerWithNumberOfOrders{" +
          "customerNumber=" + customerNumber +
          ", name='" + name + '\'' +
          ", customerName='" + customerName + '\'' +
          ", count=" + count +
          '}';
  }
}
