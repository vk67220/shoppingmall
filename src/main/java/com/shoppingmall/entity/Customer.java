package com.shoppingmall.entity;

import javax.persistence.*;

/**
 * @author muralinutalapati
 */
@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_number")
	private int id;

	@Column(name = "customer_name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer(String name) {
		this.name = name;
	}

	public Customer() {
	}

	@Override
	public String toString() {
		return "Customer{" +
					"id=" + id +
					", name='" + name + '\'' +
					'}';
	}
}
