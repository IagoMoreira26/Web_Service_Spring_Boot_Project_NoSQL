package com.iagomoreira.workshopmongo.services;

import java.util.List;

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

	public List<Post> findByTitle(String text) {
		return postRepository.findByTitle(text);
	}

}
