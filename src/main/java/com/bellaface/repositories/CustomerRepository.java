package com.bellaface.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bellaface.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query(value = "SELECT * FROM customer WHERE login = :login and password = :password", nativeQuery = true)
	Customer retornarUsuarioExistente(@Param("login") String login, @Param("password") String password);

}
