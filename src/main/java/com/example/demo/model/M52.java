package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.contract.M51M52Contract;
import com.example.demo.model.base.DBItem;

@Entity
@Table(name = "m52")
public class M52 extends DBItem {
	private String attM52;
	
	@OneToOne(targetEntity=M51M52.class)
	private M51M52 associationTable;

	public String getAttM52() {
		return attM52;
	}

	public void setAttM52(String attM52) {
		this.attM52 = attM52;
	}

	public M51M52 getAssociationTable() {
		return associationTable;
	}

	public void setAssociationTable(M51M52 associationTable) {
		this.associationTable = associationTable;
	}
}
