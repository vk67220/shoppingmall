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
	@Column(name = "customerNumber")
	private int id;
}
