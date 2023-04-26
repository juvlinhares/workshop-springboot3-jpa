package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DataBaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundExceptions;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundExceptions(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
			
		}catch(EmptyResultDataAccessException e){
			//lanço minha exceção personalizada:
			throw new ResourceNotFoundExceptions(id);
		}catch(DataIntegrityViolationException e) {
			//lanço a minha exceção databa exception:
			throw new DataBaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {
		// cria o entity recebendo o get.reference do repositório
		User entity = repository.getReferenceById(id);

		// chama o método que seta as informações:
		updateData(entity, obj);

		// salva o novo entity no bd:
		return repository.save(entity);
	}

	public void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
