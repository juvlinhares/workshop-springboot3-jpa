package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController //pra n colocar body em todos os metodos
@RequestMapping(value="/users")// url de acesso
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1L, "maria", "maria@gmail.com", "99999999", "123456");
		
		return ResponseEntity.ok().body(user);
	}

}
