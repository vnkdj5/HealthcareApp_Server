package com.heathcare.app.pojos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name = "patient")
public class Patient {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private Date dateOfBirth;
	@Column
	private String address;

	/**
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param dateOfBirth
	 */
	public Patient(String firstName, String lastName, String password, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * 
	 */
	public Patient() {
		super();
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param dateOfBirth
	 * @param address
	 */
	public Patient(int id, String firstName, String lastName, String email, String password, Date dateOfBirth,
			String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", address=" + address + "]";
	}

}
