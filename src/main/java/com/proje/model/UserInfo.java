package com.proje.model;

import java.util.Date;

public class UserInfo {

	private String username;

	private String firstName;

	private String lastName;

	private Date birthDate;

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(String username, String firstName, String lastName, Date birthDate) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getBirthOfDate() {
		return birthDate;
	}

	public void setBirthOfDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
