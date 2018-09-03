package com.example.demo.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.contract.M3Contract;
import com.example.demo.model.base.DBItem;

@Entity
@Table(name = "m4")
public class M4 extends DBItem {

	private String attM4;

	@OneToMany(targetEntity=M3.class,mappedBy = M3Contract.M4)
	private Collection<M3> m3s;

	@ManyToMany(targetEntity=M3.class,mappedBy = M3Contract.M4S)
	private Collection<M3> m3ss;

	public String getAttM4() {
		return attM4;
	}

	public void setAttM4(String attM4) {
		this.attM4 = attM4;
	}

	public Collection<M3> getM3s() {
		return m3s;
	}

	public void setM3s(Collection<M3> m3s) {
		this.m3s = m3s;
	}

	public Collection<M3> getM3ss() {
		return m3ss;
	}

	public void setM3ss(Collection<M3> m3ss) {
		this.m3ss = m3ss;
	}
}
