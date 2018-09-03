package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.contract.M51Contract;
import com.example.demo.contract.M52Contract;
import com.example.demo.model.base.DBItem;

@Entity
@Table(name = "m51m52")
public class M51M52 extends DBItem {

	@OneToOne(targetEntity=M51.class,mappedBy=M51Contract.ASSOCIATION_TABLE)
	private M51 leftAssociation;
	
	@OneToOne(targetEntity=M52.class,mappedBy=M52Contract.ASSOCIATION_TABLE)
	private M52 rightAssociation;
	
	private String data;

	public M51 getLeftAssociation() {
		return leftAssociation;
	}

	public void setLeftAssociation(M51 leftAssociation) {
		this.leftAssociation = leftAssociation;
	}

	public M52 getRightAssociation() {
		return rightAssociation;
	}

	public void setRightAssociation(M52 rightAssociation) {
		this.rightAssociation = rightAssociation;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
