package com.bellaface.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bellaface.entities.Customer;
import com.bellaface.entities.LoginForm;
import com.bellaface.exceptions.BusinessException;
import com.bellaface.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	
	public Customer retornarUsuarioExistente(LoginForm loginForm) {
		
		Customer customerLogin =  repository.retornarUsuarioExistente(loginForm.getLogin(), loginForm.getPassword());
		
		if(customerLogin==null) {
			throw new BusinessException("O login e/ou password informados não são válidos.");
		}
		
		return customerLogin;
	}
	
}
