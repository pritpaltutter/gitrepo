package org.pritpal.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity (name = "User_Details")
public class UserDetails {
	private int userID;
	private String userName;
	/*@Embedded
	
	private Address home_Address;
	
	@Embedded
	private Address office_Address;
	*/
	
	
	private Collection<Address> allAddress = new ArrayList();
	@Id
	@Column (name = "USER_ID")
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	@Column (name = "USER_NAME")
	public String getUserName() {
		return userName;
	}
	
	
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@ElementCollection
	
	@JoinTable (name = "User_Address" , joinColumns= @JoinColumn(name="USER_ID"))
	@GenericGenerator(name = "hilo-gen",strategy = "hilo")
	@CollectionId(columns = { @Column(name = "Address_ID") }, generator = "hilo-gen", type = @Type(type ="long"))
	public Collection<Address> getAllAddress() {
		return allAddress;
	}
	public void setAllAddress(Collection<Address> allAddress) {
		this.allAddress = allAddress;
	}
	
	
	
	
	
	/*@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name = "home_street")),
		@AttributeOverride(name = "state", column = @Column(name = "home_state")),
		@AttributeOverride(name = "city", column = @Column(name = "home_city"))
	})
	public Address getHome_Address() {
		return home_Address;
	}
	public void setHome_Address(Address home_Address) {
		this.home_Address = home_Address;
	}
	public Address getOffice_Address() {
		return office_Address;
	}
	public void setOffice_Address(Address office_Address) {
		this.office_Address = office_Address;
	}*/
	
	
}
