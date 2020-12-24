package com.mentorondemand.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String rolename;
	
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


