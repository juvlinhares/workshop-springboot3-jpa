package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;


@RestController //é um recurso web implementado por um controlador rest
@RequestMapping(value = "/users") // nome do recurso, gera um endpoint de acesso
public class UserResource {
	
	//teste: metodo endpoint pra acessar os usuários
	//ResponseEntity: retorna respostas de requisições web
	@GetMapping //indica que esse método é um get http 
	public ResponseEntity<User> findAll() {
		User usuario = new User(1L, "Maria", "Maria@gmail.com", "99999999", "12345");
		
		return ResponseEntity.ok().body(usuario);
	}

}
