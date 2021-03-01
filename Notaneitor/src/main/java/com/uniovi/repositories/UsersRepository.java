package com.uniovi.repositories;
import com.uniovi.entities.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long>{
	
	User findByDni(String dni);
	
	@Query("SELECT r FROM User r WHERE (LOWER(r.name) LIKE LOWER(?1) OR LOWER(r.lastName) LIKE LOWER(?1))")
	Page<User> searchByNameOrLastName(Pageable pageable,String searchtext);

	Page<User> findAll(Pageable pageable);
}