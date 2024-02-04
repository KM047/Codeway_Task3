package com.codeWay.courseRegistrationSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class AdminModel {

	@Id

	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
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

	@Override
	public String toString() {
		return "AdminModel [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

}
