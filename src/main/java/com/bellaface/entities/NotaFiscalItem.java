package com.bellaface.entities;


import java.io.Serializable;
import java.math.BigDecimal;


public class NotaFiscalItem implements Serializable{

	private static final long serialVersionUID = 5794690346270791058L;
	
	private Integer idProduto;
	private String nome;
	private String descricao;
	private Integer quantidade;
	private BigDecimal precoUnitario;
	private BigDecimal valorTotalItem;
	
	
	
	public NotaFiscalItem() {
		
	}
	
	
	public NotaFiscalItem(Integer idProduto, String nome, String descricao, Integer quantidade,
			BigDecimal precoUnitario, BigDecimal valorTotalItem) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.valorTotalItem = valorTotalItem;
	}
	
	
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public BigDecimal getValorTotalItem() {
		return valorTotalItem;
	}
	public void setValorTotalItem(BigDecimal valorTotalItem) {
		this.valorTotalItem = valorTotalItem;
	}
	
}
