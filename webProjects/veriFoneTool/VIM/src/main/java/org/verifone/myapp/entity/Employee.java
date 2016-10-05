package org.verifone.myapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Employee")
public class Employee {

	private int employeeId;
	private String employeeName;
	private String employeeCubicalNumber;

	
	@Id
	@GeneratedValue
	@Column(name="EmployeeId")
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	@Column(name="EmployeeName")
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@Column(name="EmployeeCubicalNo")
	public String getEmployeeCubicalNumber() {
		return employeeCubicalNumber;
	}
	public void setEmployeeCubicalNumber(String employeeCubicalNumber) {
		this.employeeCubicalNumber = employeeCubicalNumber;
	}
		
	public String toString(){
		return getEmployeeId()+":"+getEmployeeName();
		
	}
}
