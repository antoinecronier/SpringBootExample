package com.example.demo.model;

public class MonModele {
	private Long key;
	private String truc;
    private String bidule;
    private Integer monInt;
    private Boolean maBoule;
    private String[] mesTrucs;
    
	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

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
	
	public MonModele(Long key, String truc, String bidule, Integer monInt, Boolean maBoule, String[] mesTrucs) {
        super();
        this.key = key;
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
