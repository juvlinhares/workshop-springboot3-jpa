package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		//gerar a entidadede referencia:
		User entity = repository.getReferenceById(id);
		
		//chamar o método update da entidade(entity)
		updateData(entity, obj);
		
		//retornar/salvar a entidade atualizada no BD
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		//setar as informações novas (obj) no user antigo(entity):
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
		
	}

}
