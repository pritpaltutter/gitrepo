package com.test.secondtest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Stock_Holder")
public class StockHolder {
	
	@Id @GeneratedValue
	public int stockHolderID;
	@Column (name = "Stock_Holder_Name")
	public String stockHolderName;
	@Column (name = "Stock_Holder_Address")
	public String stockHolderAddress;
	@ManyToOne
	public Stock stockOwned;
	
	public Stock getStockOwned() {
		return stockOwned;
	}
	public void setStockOwned(Stock stockOwned) {
		this.stockOwned = stockOwned;
	}
	public String getStockHolderName() {
		return stockHolderName;
	}
	public void setStockHolderName(String stockHolderName) {
		this.stockHolderName = stockHolderName;
	}
	public String getStockHolderAddress() {
		return stockHolderAddress;
	}
	public void setStockHolderAddress(String stockHolderAddress) {
		this.stockHolderAddress = stockHolderAddress;
	}
	
	
}
