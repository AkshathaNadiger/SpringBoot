package com.ecom.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.customer.entity.CustomerEntity;


@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
	
	@Query("SELECT c FROM CustomerEntity c LEFT JOIN FETCH c.orders")
	public List<CustomerEntity> getAllOrdersOfCustomer(); 
	
//	@Override
//	@EntityGraph(attributePaths = {"orders"})
//	List<CustomerEntity> findAll();
	
}
