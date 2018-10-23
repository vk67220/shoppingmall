package com.shoppingmall.entity;

import javax.persistence.*;
import java.util.List;

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

	@Column(name = "customerName")
	private String name;

	@Column(name = "contactFirstName")
	private String firstName;

	@Column(name = "contactLastName")
	private String lastName;

	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "customerNumber")
	private List<Order> orders;

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	public Customer() {
	}

	public Customer(String name, String firstName, String lastName, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, String country) {
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}

	public Customer(String name, String firstName, String lastName) {
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer{" +
					"id=" + id +
					", name='" + name + '\'' +
					", firstName='" + firstName + '\'' +
					", lastName='" + lastName + '\'' +
					", phone='" + phone + '\'' +
					", addressLine1='" + addressLine1 + '\'' +
					", addressLine2='" + addressLine2 + '\'' +
					", city='" + city + '\'' +
					", state='" + state + '\'' +
					", postalCode='" + postalCode + '\'' +
					", country='" + country + '\'' +
					", orders=" + orders +
					'}';
	}
}
