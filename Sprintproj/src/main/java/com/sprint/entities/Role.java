package com.sprint.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    int id;
	String rolename;
	
	public Role()
	{
		super();
	}
	public Role(String rolename) {
		super();
		this.rolename = rolename;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	@Override
	public String toString() {
		return "Role [RoleId=" + id + ", RoleName=" + rolename + "]";
	}
	
}


