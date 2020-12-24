package com.mentorondemand.entities;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	@Transient
	String confirmPassword;
	@ManyToOne(cascade = CascadeType.ALL)
	private Role role;
	
	public User(String name, String email, String password,String phno) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phno=phno;
	
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
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}


	@Override
	public String toString() {
		return "User [id=" + id+ ", name=" + name + ", email=" + email + ", password=" + password + ", Phno"
				+ phno+ "]";
	}
	
	
	

}
