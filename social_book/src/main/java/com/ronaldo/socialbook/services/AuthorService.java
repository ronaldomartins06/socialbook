package com.ronaldo.socialbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronaldo.socialbook.domain.Author;
import com.ronaldo.socialbook.repository.AuthorRepository;
import com.ronaldo.socialbook.service.exceptions.AuthorException;
import com.ronaldo.socialbook.service.exceptions.AuthorNotFoundException;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public List<Author> listAll(){
		return authorRepository.findAll();
	}

	public Author saveAuthor(Author author){
		if( author.getId() != null ){
			Author aut = authorRepository.findOne(author.getId());
			
			if( aut != null ){
				throw new AuthorException("This Author already exists");
			}
		}
		return authorRepository.save(author);
	}
	
	public Author findAuthor(Long id){
		Author author = authorRepository.findOne(id);
		
		if( author == null ){
			throw new AuthorNotFoundException("Author could not be found.");
		}
		
		return author;
	}
	
}
