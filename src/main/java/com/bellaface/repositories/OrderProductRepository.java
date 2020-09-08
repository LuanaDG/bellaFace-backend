package com.bellaface.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bellaface.entities.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer>{

}
