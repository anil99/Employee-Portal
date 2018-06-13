package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotEmpty;

import antlr.collections.List;

@Entity
public class Employee {

	// @NotEmpty(message = "con't be empty")
	private String name;
	private String country;
	private String password;
	private int attendace;
	/**
	 * @return the attendace
	 */
	public int getAttendace() {
		return attendace;
	}

	/**
	 * @param attendace the attendace to set
	 */
	public void setAttendace(int attendace) {
		this.attendace = attendace;
	}

	// @NotEmpty(message = "con't be empty")
	// @Email(message = "invalid email")
	private String email;

	// @NotEmpty(message = "con't be empty")
	private String designation;

	// @NotEmpty(message = "con't be empty")
	// @Min(value = 18000)
	private double salary;

	@Id
	// @NotEmpty(message = "con't be empty")
	// @Min(value = 999999999 , message ="invalid")
	private int contact;

	/**
	 * @return the name
	 */

	public String getName() {
		return name;
	}

	public Employee() {

	}

	public Employee(String name, String email, String designation, double salary, int contact, String country,
			String password , int attendance) {
		super();
		this.name = name;
		this.email = email;
		this.designation = designation;
		this.salary = salary;
		this.contact = contact;
		this.country = country;
		this.password = password;
		this.attendace = attendance;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the contact
	 */
	public int getContact() {
		return contact;
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(int contact) {
		this.contact = contact;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation
	 *            the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

}
