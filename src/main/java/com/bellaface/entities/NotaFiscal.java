package com.bellaface.entities;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;


public class NotaFiscal implements Serializable{

	private static final long serialVersionUID = 2754137874997951569L;

	private Integer idOrder;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT" )
	private Date dataVenda;
	
	
	private BigDecimal valorTotal;
	private String comments;
	
	private List<NotaFiscalItem> itemList;
	
	public NotaFiscal() {
		
	}

	public NotaFiscal(Integer idOrder, Date dataVenda, BigDecimal valorTotal, String comments,
			List<NotaFiscalItem> itemList) {
		this.idOrder = idOrder;
		this.dataVenda = dataVenda;
		this.valorTotal = valorTotal;
		this.comments = comments;
		this.itemList = itemList;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<NotaFiscalItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<NotaFiscalItem> itemList) {
		this.itemList = itemList;
	}
	

	
	
}
