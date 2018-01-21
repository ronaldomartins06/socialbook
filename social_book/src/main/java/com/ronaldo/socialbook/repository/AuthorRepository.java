package com.ronaldo.socialbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronaldo.socialbook.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
