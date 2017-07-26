package com.ronaldo.socialbook.resources;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ronaldo.socialbook.domain.Book;

@RestController
public class BookResources {

	@RequestMapping(value="/books", method = RequestMethod.GET)
	public List<Book> list(){
		
		Book book1 = new Book("Application Rest");
		Book book2 = new Book("Spring Boot API");
		
		Book[] books = {book1, book2};
		return Arrays.asList(books);
	}
}
