package com.iagomoreira.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iagomoreira.workshopmongo.domain.User;
import com.iagomoreira.workshopmongo.dto.UserDTO;
import com.iagomoreira.workshopmongo.repository.UserRepository;
import com.iagomoreira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	};

	public User insert(User user) {
		return userRepository.insert(user);
	}

	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}

	public User update(User user) {
		User newObj = userRepository.findById(user.getId())
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		;
		updateData(newObj, user);
		return userRepository.save(newObj);
	}

	private void updateData(User newObj, User user) {
		newObj.setName(user.getName());
		newObj.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}

}
