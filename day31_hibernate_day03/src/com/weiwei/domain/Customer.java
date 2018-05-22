package com.weiwei.domain;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer id;
	private String name;
	private Set<Order> orders = new HashSet<Order>();
	private Integer version;
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", orders=" + orders
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Customer(){
		super();
	}
	
	public Customer(Integer id,String name){
		super();
		this.id = id;
		this.name = name;
	}
	
}
