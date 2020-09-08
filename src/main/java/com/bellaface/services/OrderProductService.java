package com.bellaface.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bellaface.entities.OrderProduct;
import com.bellaface.repositories.OrderProductRepository;

@Service
public class OrderProductService {
	
	@Autowired
	private OrderProductRepository orderRepository;
	
	public OrderProduct salvar(OrderProduct entity) {
		return orderRepository.save(entity);
	}

}
