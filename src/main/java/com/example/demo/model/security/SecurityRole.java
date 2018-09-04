package com.example.demo.model.security;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.demo.model.base.DBItem;

@Entity
@Table(name = "security_role")
public class SecurityRole extends DBItem{

	private String role;

	@ManyToMany(targetEntity=SecurityUser.class)
	@JoinTable(name = "users_securityroles",
    	joinColumns = @JoinColumn(name = "role_id"),
    	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<SecurityUser> users;

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the users
	 */
	public Set<SecurityUser> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<SecurityUser> users) {
		this.users = users;
	}

	public SecurityRole() {
	}
}
