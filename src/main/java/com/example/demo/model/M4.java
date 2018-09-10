package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.contract.M3Contract;
import com.example.demo.model.base.DBItem;
import com.example.demo.model.serializer.M4Serializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "m4")
//@JsonSerialize(using = M4Serializer.class)
public class M4 extends DBItem {

	private String attM4;

	@OneToMany(targetEntity=M3.class,mappedBy = M3Contract.M4)
	@JsonIgnoreProperties(allowSetters=true,value= {M3Contract.M4S})
	private Set<M3> m3s;

	@ManyToMany(targetEntity=M3.class)
	@JoinTable(name = "m3_m4s",
	joinColumns = @JoinColumn(name = "m4s_id"),
	inverseJoinColumns = @JoinColumn(name = "m3ss_id"))
	@JsonIgnoreProperties(allowSetters=true,value= {M3Contract.M4S})
	private Set<M3> m3ss;

	public String getAttM4() {
		return attM4;
	}

	public void setAttM4(String attM4) {
		this.attM4 = attM4;
	}

	public Set<M3> getM3s() {
		return m3s;
	}

	public void setM3s(Set<M3> m3s) {
		this.m3s = m3s;
	}

	public Set<M3> getM3ss() {
		return m3ss;
	}

	public void setM3ss(Set<M3> m3ss) {
		this.m3ss = m3ss;
	}
}
