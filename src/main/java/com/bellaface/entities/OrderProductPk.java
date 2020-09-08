package com.bellaface.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderProductPk implements Serializable{
	
	private static final long serialVersionUID = -1745627363580064173L;

	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "product_id")
	private Integer productId;
	

	public OrderProductPk() {
		
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	

}
