package com.ronaldo.socialbook.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronaldo.socialbook.domain.Book;
import com.ronaldo.socialbook.domain.Description;
import com.ronaldo.socialbook.repository.BookRepository;
import com.ronaldo.socialbook.repository.DescriptionRepository;
import com.ronaldo.socialbook.service.exceptions.BookNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private DescriptionRepository descriptionRepository;
	
	public List<Book> list(){
		return bookRepository.findAll();
	}
	
	public Book findOne(Long id){
		Book book = bookRepository.findOne(id);
		
		if( book == null ){
			throw new BookNotFoundException("The required was not found!");
		}
		return book;
	}
	
	public Book save(Book book){
		book.setId(null);
		return bookRepository.save(book);
	}
	
	public void delete(Long id){
		try {
			bookRepository.delete(id);
		} catch (BookNotFoundException e) {
			throw new BookNotFoundException("The Book required couldn't be found!");
		}
	}
	
	public void updateBook(Book book){
		checkIfBookExists(book);
		bookRepository.save(book);
	}

	public Description saveDescription(Long bookId, Description description){
		Book book = findOne(bookId);
		description.setBook(book);
		description.setTextDate(new Date());
		
		return descriptionRepository.save(description);
	}
	
	private void checkIfBookExists(Book book) {
		findOne(book.getId());
	}

	public List<Description> listFullDescription(Long bookId) {
		Book book = findOne(bookId);
		return book.getDescription();
	}
	
	
}
