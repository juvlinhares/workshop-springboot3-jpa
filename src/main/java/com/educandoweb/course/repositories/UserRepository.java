package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

//é uma interface de JPA repository
public interface UserRepository extends JpaRepository<User, Long>{

}
