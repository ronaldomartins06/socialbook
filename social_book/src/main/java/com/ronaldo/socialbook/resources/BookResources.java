package com.ronaldo.socialbook.resources;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;

import com.ronaldo.socialbook.domain.Book;
import com.ronaldo.socialbook.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookResources {

	@Autowired
	private BookRepository bookRepository;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Book> list(){
		return bookRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void saveBook(@RequestBody Book book){
		bookRepository.save(book);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Book findOne(@PathVariable("id") Long id){
		return bookRepository.findOne(id);
	}
}
