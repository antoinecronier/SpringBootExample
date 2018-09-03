package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.model.base.DBItem;

@Entity
@Table(name="daBidule")
public class MonModele extends DBItem {
	
	private String truc;
    private String bidule;
    private Integer monInt;
    private Boolean maBoule;
    private String[] mesTrucs;

	public Boolean getMaBoule() {
		return maBoule;
	}

	public String getTruc() {
		return truc;
	}

	public void setTruc(String truc) {
		this.truc = truc;
	}

	public String getBidule() {
		return bidule;
	}

	public void setBidule(String bidule) {
		this.bidule = bidule;
	}

	public Integer getMonInt() {
		return monInt;
	}

	public void setMonInt(Integer monInt) {
		this.monInt = monInt;
	}

	public void setMaBoule(Boolean maBoule) {
		this.maBoule = maBoule;
	}

	public String[] getMesTrucs() {
		return mesTrucs;
	}

	public void setMesTrucs(String[] mesTrucs) {
		this.mesTrucs = mesTrucs;
	}
	
	public MonModele(Long id, String truc, String bidule, Integer monInt, Boolean maBoule, String[] mesTrucs) {
        super();
        super.id = id;
        this.truc = truc;
        this.bidule = bidule;
        this.monInt = monInt;
        this.maBoule = maBoule;
        this.mesTrucs = mesTrucs;
    }
	
    public MonModele(String truc, String bidule, Integer monInt, Boolean maBoule, String[] mesTrucs) {
        super();
        this.truc = truc;
        this.bidule = bidule;
        this.monInt = monInt;
        this.maBoule = maBoule;
        this.mesTrucs = mesTrucs;
    }
    
    public MonModele() {

    }
}
