package com.spring.rest.mongo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "person")
public class Person {

	@Id
	private int id;
	@NotNull
	@Column(unique = true)
	//@UniqueConstraint(columnNames = { "name" })
	@MongoId
	private String name;
	@NotNull
	private String mobileNumber;
	@NotNull
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date dob;
	private Address address;
	
	public Person() {
		super();
	}
	public Person(int id, String name, String mobileNumber, Date dob, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.dob = dob;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}