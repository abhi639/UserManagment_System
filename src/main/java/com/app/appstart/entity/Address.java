package com.app.appstart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Add_id;
	
	private String adress_type;
	
	private String  street;
	
	private String line1;
	
	private String line2;
	
	private String city;
	
	private String state;
	
	private String pincode;

	public long getAdd_id() {
		return Add_id;
	}

	public void setAdd_id(long add_id) {
		Add_id = add_id;
	}

	public String getAdress_type() {
		return adress_type;
	}

	public void setAdress_type(String adress_type) {
		this.adress_type = adress_type;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Address(long add_id,  String street, String line1, String line2, String city,
			String state, String pincode) {
		super();
		Add_id = add_id;
		
		this.street = street;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Address(String adress_type, String street, String line1, String line2, String city, String state,
			String pincode) {
		super();
		this.adress_type = adress_type;
		this.street = street;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Address() {
		super();
	}
	
	
	
	
}
