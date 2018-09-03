package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.contract.M51M52Contract;
import com.example.demo.model.base.DBItem;

@Entity
@Table(name = "m51")
public class M51 extends DBItem {

	private String attM51;
	
	@OneToOne(targetEntity=M51M52.class)
	private M51M52 associationTable;

	public String getAttM51() {
		return attM51;
	}

	public void setAttM51(String attM51) {
		this.attM51 = attM51;
	}

	public M51M52 getAssociationTable() {
		return associationTable;
	}

	public void setAssociationTable(M51M52 associationTable) {
		this.associationTable = associationTable;
	}
}
