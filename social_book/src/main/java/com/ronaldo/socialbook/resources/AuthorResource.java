package com.ronaldo.socialbook.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ronaldo.socialbook.domain.Author;
import com.ronaldo.socialbook.services.AuthorService;

@Controller
@RequestMapping("/author")
public class AuthorResource {

	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(method= RequestMethod.GET, produces={
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Author>> list(){
		List<Author> authors = authorService.listAll();
		return ResponseEntity.status(HttpStatus.OK).body(authors);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody Author author){
		author = authorService.saveAuthor(author);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(author.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Author> findAuthor(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(authorService.findAuthor(id));
	}
	
	
}
