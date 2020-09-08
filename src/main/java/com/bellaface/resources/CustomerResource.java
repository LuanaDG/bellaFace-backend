package com.bellaface.resources;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bellaface.entities.Customer;
import com.bellaface.entities.LoginForm;
import com.bellaface.exceptions.BusinessException;
import com.bellaface.services.CustomerService;


@RestController
@RequestMapping(value = "/customer")
public class CustomerResource {

	@Autowired
	private CustomerService service;
	
	@PostMapping(value = "/login")
	public ResponseEntity<Serializable> retornarUsuarioExistente(@RequestBody LoginForm obj) {
		try {
			Customer customer = service.retornarUsuarioExistente(obj);
			return ResponseEntity.ok().body(customer);
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
}
