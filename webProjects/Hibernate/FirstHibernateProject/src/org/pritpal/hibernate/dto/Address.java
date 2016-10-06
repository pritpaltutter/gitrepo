package org.pritpal.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	

private String street;


private String state;


private String city;


@Column (name="STREET_Address")
public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}
@Column (name="STATE_Address")
public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}
@Column (name="CITY_Address")
public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

}
