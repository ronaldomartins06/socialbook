package com.ronaldo.socialbook.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message="The field can't be empty")
	private String name;

	@JsonFormat(pattern="dd/MM/yyyy")
	@NotNull(message="Filed is mandatory")
	private Date birthday;
	@JsonInclude(Include.NON_NULL)
	@NotNull(message="Field is mandatory")
	private String nationality;
	
	@OneToMany(mappedBy="author")
	@JsonIgnore
	private List<Book> listBook;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public List<Book> getListBook() {
		return listBook;
	}
	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}

	
}
