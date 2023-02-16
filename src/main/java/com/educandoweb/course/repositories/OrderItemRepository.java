package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.OrderItem;

//é uma interface de JPA repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
