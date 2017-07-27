package com.ronaldo.socialbook.repository;
import com.ronaldo.socialbook.domain.*;

import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book, Long>{
	
	

}
