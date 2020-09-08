package com.bellaface.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bellaface.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
