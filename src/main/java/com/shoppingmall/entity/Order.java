package com.shoppingmall.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author muralinutalapati
 */
@Entity
@Table(name = "orders")
public class Order extends AuditModel{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "orderNumber")
  private int orderNumber;
  private Date orderDate;
  private Date requiredDate;
  private Date shippedDate;
  private String status;
  private String comments;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customerNumber", nullable = false)
  private Customer customer;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "orderNumber")
  private List<OrderDetails> orderDetails;

  public Order(Date orderDate, Date requiredDate, Date shippedDate, String status, String comments) {
    this.orderDate = orderDate;
    this.requiredDate = requiredDate;
    this.shippedDate = shippedDate;
    this.status = status;
    this.comments = comments;
  }

  public Order() {
  }

  public List<OrderDetails> getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(List<OrderDetails> orderDetails) {
    this.orderDetails = orderDetails;
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

  public Date getRequiredDate() {
    return requiredDate;
  }

  public void setRequiredDate(Date requiredDate) {
    this.requiredDate = requiredDate;
  }

  public Date getShippedDate() {
    return shippedDate;
  }

  public void setShippedDate(Date shippedDate) {
    this.shippedDate = shippedDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  @Override
  public String toString() {
    return "Order{" +
          "orderNumber=" + orderNumber +
          ", orderDate=" + orderDate +
          ", requiredDate=" + requiredDate +
          ", shippedDate=" + shippedDate +
          ", status='" + status + '\'' +
          ", comments='" + comments + '\'' +
          '}';
  }
}
