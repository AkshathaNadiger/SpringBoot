package com.ecom.customer.entity;

import java.util.List;

import com.ecom.orders.entity.OrdersEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class CustomerEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //Primary key in customer table
	
	private String name;
	private String email;
	private String address;
	private String phNo;
	private String status;
	
	//Getting orders List here one customer can have multiple orders
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrdersEntity> orders;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<OrdersEntity> getOrders() {
		return orders;
	}
	public void setOrders(List<OrdersEntity> orders) {
		this.orders = orders;
	}
	
	

}
