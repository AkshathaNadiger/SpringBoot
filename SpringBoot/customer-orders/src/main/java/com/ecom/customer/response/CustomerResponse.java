package com.ecom.customer.response;


//This class defines what are the response customers gets after creating a customer in DB like after signup we will get account created username and pass etc
public class CustomerResponse {
	
    private Long id;
	
	private String name;
	
	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
