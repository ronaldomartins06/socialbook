package com.ronaldo.socialbook.resources;


import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ronaldo.socialbook.domain.Book;
import com.ronaldo.socialbook.domain.Description;
import com.ronaldo.socialbook.services.BookService;

@RestController
@RequestMapping("/books")
public class BookResources {

	@Autowired
	private BookService bookService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Book>> list(){
		return ResponseEntity.status(HttpStatus.OK).body(bookService.list());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveBook(@Valid @RequestBody Book book){
		book = bookService.save(book);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}").buildAndExpand(book.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable("id") Long id){
		Book book = bookService.findOne(id);
		
		CacheControl cacheControl = CacheControl.maxAge(60, TimeUnit.SECONDS);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(book);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		bookService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Book book,  @PathVariable("id") Long id){
		book.setId(id);
		bookService.updateBook(book);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}/description", method = RequestMethod.POST)
	public ResponseEntity<Void> addDescription(@PathVariable("id") Long bookId, 
									@RequestBody Description description){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		description.setUser(auth.getName());
		
		bookService.saveDescription(bookId, description);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="{id}/description", method = RequestMethod.GET)
	public ResponseEntity<List<Description>> listDescription(@PathVariable("id") Long bookId){
		List<Description>  descriptions = bookService.listFullDescription(bookId);
		
		return ResponseEntity.status(HttpStatus.OK).body(descriptions);
	}
}
