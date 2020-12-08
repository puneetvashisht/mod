package com.sprint.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String email;
	String password;
    String phno;
    @Column(name = "role")
	String role = "user";
	@Transient
	String confirmPassword;
	
	public User() {}
	public User(String name, String email, String password,String phno,String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phno=phno;
		this.role=role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setPhno(String phno) {
		this.phno = phno;
	}

public String getPhno() {
	return phno;
}
public void setPassword(String password) {
	this.password = password;
}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		// TODO Auto-generated method stub
		return role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", Phno"
				+ phno+ "]";
	}
	
	
	

}
