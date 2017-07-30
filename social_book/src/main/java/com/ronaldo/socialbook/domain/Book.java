package com.ronaldo.socialbook.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Book {

	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonInclude(Include.NON_NULL)
	private String name;
	@JsonInclude(Include.NON_NULL)
	private String publisher;
	@JsonInclude(Include.NON_NULL)
	private String author;
	@JsonInclude(Include.NON_NULL)
	private String summary;
	@JsonInclude(Include.NON_NULL)
	private Date realese;
	
	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy="book")
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
