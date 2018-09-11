package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.model.base.DBItem;

@Entity
@Table(name = "m2")
public class M2 extends DBItem {

	private String data;
	private Boolean activate;
	
	@OneToMany(targetEntity=MonModele.class)
	private Collection<MonModele> modelsss;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Boolean getActivate() {
		return activate;
	}

	public void setActivate(Boolean activate) {
		this.activate = activate;
	}

	public Iterable<MonModele> getModelsss() {
		return modelsss;
	}

	public void setModelsss(Collection<MonModele> modelsss) {
		this.modelsss = modelsss;
	}

	public M2() {
		this.modelsss = new ArrayList<MonModele>();
	}
}
