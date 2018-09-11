package com.example.demo.model.security;

import java.util.Set;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.demo.contract.M4Contract;
import com.example.demo.converter.CryptoConverter;
import com.example.demo.model.base.DBItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// If abstract
//@MappedSuperclass
//@Inheritance
@Entity
@Table(name = "security_user")
public class SecurityUser extends DBItem {

	private String login;
	@Convert(converter=CryptoConverter.class)
	private String password;
	private Boolean enable;

	@ManyToMany(targetEntity=SecurityRole.class)
	@JoinTable(name = "users_securityroles",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id"))
	@JsonIgnoreProperties(allowSetters = true, value = {"users"})
	private Set<SecurityRole> roles;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
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
	 * @return the enable
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	/**
	 * @return the roles
	 */
	public Set<SecurityRole> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<SecurityRole> roles) {
		this.roles = roles;
	}

	public SecurityUser() {
	}
}
