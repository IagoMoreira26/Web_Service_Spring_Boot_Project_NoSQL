package com.iagomoreira.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iagomoreira.workshopmongo.domain.Post;
import com.iagomoreira.workshopmongo.repository.PostRepository;
import com.iagomoreira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	};

}
