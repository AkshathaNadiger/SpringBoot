package com.ecom.orders.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.customer.entity.CustomerEntity;
import com.ecom.orders.entity.OrdersEntity;

@Repository
public interface OrdersRepository extends CrudRepository<OrdersEntity, Long>{
	

	

}
