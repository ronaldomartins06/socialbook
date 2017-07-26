package com.ronaldo.socialbook.domain;

import java.util.Date;
import java.util.List;

public class Book {

	private Long id;
	private String name;
	private String publisher;
	private String author;
	private String summary;
	private Date realese;
	private List<Description> description;
	
	public Book(){}
	public Book(String name){
		this.name = name;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getRealese() {
		return realese;
	}
	public void setRealese(Date realese) {
		this.realese = realese;
	}
	public List<Description> getDescription() {
		return description;
	}
	public void setDescription(List<Description> description) {
		this.description = description;
	}
	
}
