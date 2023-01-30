package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service
public class OrderService {

	//1- dependencia de Order repository:
	@Autowired
	private OrderRepository repository;

	//2- metodo findAll:
	public List<Order> findAll(){
		
		return repository.findAll();
	}
	
	//3- metodo findById:
	public Order findById (Long id) {
		Optional<Order> order = repository.findById(id);
		
		return order.get();
	}
}
