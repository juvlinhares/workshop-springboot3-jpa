package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.fasterxml.jackson.annotation.OptBoolean;

@Service
public class UserService {

	//gerar dependencia com o repository:
	@Autowired
	private UserRepository repository;
	
	//buscar todos os usuários e buscar um usuário por id 
	public List<User> findAll(){
		
		return repository.findAll();
	}
	
	//buscar usuário por id:
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		
		return user.get();
	}
}
