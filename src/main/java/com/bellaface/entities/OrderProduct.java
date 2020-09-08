package com.bellaface.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "order_product")
public class OrderProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderProductPk id;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT" )
	@Column(name = "created_at",insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;
	
	@Column(name = "unit_price")
	private BigDecimal unitPrice;
	
	@Column(name = "total_price")
	private BigDecimal totalPrice;
	

	
	public OrderProduct() {
	}
	

	public OrderProduct(OrderProductPk id, Integer quantity, LocalDateTime createdAt, BigDecimal unitPrice,
			BigDecimal totalPrice) {
		this.id = id;
		this.quantity = quantity;
		this.createdAt = createdAt;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}



	public OrderProductPk getId() {
		return id;
	}

	public void setId(OrderProductPk id) {
		this.id = id;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}



	public BigDecimal getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

}
