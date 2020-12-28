package com.mentorondemand.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int id;
	private String roleName;
	
	public Role()
	{
		super();
	}
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRolename(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString()
	{
		return "Role [RoleId=" + id + ", RoleName=" + roleName + "]";
	}
	
}


