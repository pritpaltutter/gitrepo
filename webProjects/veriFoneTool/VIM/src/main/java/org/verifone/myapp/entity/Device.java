package org.verifone.myapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author Pritpal
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Device implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int deviceId;
	private String deviceName;
	private String partNumber;
	private String serialNumber;
	private String bondNumber;
	private String bondDate;
	private String remark;
	private String additionalDescription;
	private Employee employee;
	private boolean free;
	private boolean work;
	private boolean isNew;
	
	
	@Id
	@GeneratedValue
	@Column(name="pk_deviceId")
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	
	@Column(name="DeviceName")
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
	@Column(name="PartNumber")
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	
	@Column(name="BondNumber")
	public String getBondNumber() {
		return bondNumber;
	}
	public void setBondNumber(String bondNumber) {
		this.bondNumber = bondNumber;
	}
	
	@Column(name="BondDate")
	public String getBondDate() {
		return bondDate;
	}
	public void setBondDate(String bondDate) {
		this.bondDate = bondDate;
	}

	@Column(name="Remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	@JoinColumn(name = "EmployeeId",nullable = true)  
	@ManyToOne(fetch = FetchType.LAZY)
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Column(name="SerialNumber")
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	@Column(name="AdditionalDescription")
	public String getAdditionalDescription() {
		return additionalDescription;
	}
	public void setAdditionalDescription(String additionalDescription) {
		this.additionalDescription = additionalDescription;
	}
	
	@Column(name="IsFree")
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	@Column(name="IsWorking")
	public boolean isWork() {
		return work;
	}
	public void setWork(boolean work) {
		this.work = work;
	}
	@Column(name="isNew")
	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	
	
}
