package com.example.demo.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.contract.M3Contract;
import com.example.demo.contract.M4Contract;
import com.example.demo.model.base.DBItem;

@Entity
@Table(name = "m3")
public class M3 extends DBItem {

	private String att1;

	@ManyToMany(targetEntity=M4.class)
	private Collection<M4> m4s;

	@ManyToOne(targetEntity=M4.class,optional=true)
	private M4 m4;

	@OneToOne(targetEntity=M3.class)
	private M3 m3;

	public String getAtt1() {
		return att1;
	}

	public void setAtt1(String att1) {
		this.att1 = att1;
	}

	public Collection<M4> getM4s() {
		return m4s;
	}

	public void setM4s(Collection<M4> m4s) {
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
