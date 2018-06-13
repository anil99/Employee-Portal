package com.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminDetail {
	
	@Id
	private BigInteger contact = new BigInteger("0");
	private String Name;
	private String Email;
	private String Password;
	
	
	public AdminDetail() {
		
	}
	
	
	public AdminDetail(BigInteger contact, String name, String email, String password) {
		super();
		this.contact = contact;
		this.Name = name;
		this.Email = email;
		this.Password = password;
	}


	
	/**
	 * @return the contact
	 */
	public BigInteger getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(BigInteger contact) {
		this.contact = contact;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

}
