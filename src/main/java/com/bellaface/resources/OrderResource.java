package com.bellaface.resources;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bellaface.entities.NotaFiscal;
import com.bellaface.entities.Order;
import com.bellaface.services.OrderService;



@RestController
@RequestMapping(value = "/order")
public class OrderResource {
	
	@Autowired
	private OrderService service;

	
	@PostMapping
	public ResponseEntity<Serializable> insert(@RequestBody Order obj){
	try {
		obj = service.insert(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	}
	
	@GetMapping(value = "/cupomfiscal/{idOrder}")
	public ResponseEntity<Serializable> findById(@PathVariable Integer idOrder){
		
		try {
			NotaFiscal obj = service.buscarDadosNotaFiscal(idOrder);
			return ResponseEntity.status(HttpStatus.OK).body(obj);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}