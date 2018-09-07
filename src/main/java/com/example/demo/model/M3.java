package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.example.demo.model.base.DBItem;
import com.example.demo.model.serializer.M3Serializer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "m3")
//@JsonSerialize(using = M3Serializer.class)
public class M3 extends DBItem {

	private String att1;

	@ManyToMany(targetEntity=M4.class)
	@JoinTable(name = "m3_m4s",
	joinColumns = @JoinColumn(name = "m3ss_id"),
	inverseJoinColumns = @JoinColumn(name = "m4s_id"))
	
	private Set<M4> m4s;

	@ManyToOne(targetEntity=M4.class,optional=true)
	private M4 m4;

	@OneToOne(targetEntity=M3.class)
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
	private M3 m3;

	public String getAtt1() {
		return att1;
	}

	public void setAtt1(String att1) {
		this.att1 = att1;
	}

	public Set<M4> getM4s() {
		return m4s;
	}

	public void setM4s(Set<M4> m4s) {
		this.m4s = m4s;
	}

	public M4 getM4() {
		return m4;
	}

	public void setM4(M4 m4) {
		this.m4 = m4;
	}

	public M3 getM3() {
		return m3;
	}

	public void setM3(M3 m3) {
		this.m3 = m3;
	}
}
