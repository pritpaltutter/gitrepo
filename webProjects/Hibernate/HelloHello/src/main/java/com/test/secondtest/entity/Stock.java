package com.test.secondtest.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Stock_Details")
public class Stock {

	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	public int stockNumber;
	
	@Column (name = "Stock_Value")
	public String stockValue;
	@Column (name = "Stock_Description")
	public String stockDescription;
	
	@OneToMany
	@JoinTable (name = "Mapping",joinColumns=@JoinColumn (name = "StockID"),
	inverseJoinColumns=@JoinColumn (name = "HolderID"))
	public Collection<StockHolder> stockHolder = new ArrayList<StockHolder>();
	
	
	
	public void setStockHolder(Collection<StockHolder> stockHolder) {
		this.stockHolder = stockHolder;
	}
	public String getStockValue() {
		return stockValue;
	}
	public void setStockValue(String stockValue) {
		this.stockValue = stockValue;
	}
	public String getStockDescription() {
		return stockDescription;
	}
	public void setStockDescription(String stockDescription) {
		this.stockDescription = stockDescription;
	}
	public int getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}
	
	public Collection<StockHolder> getStockHolder() {
		return stockHolder;
	}
	
}
