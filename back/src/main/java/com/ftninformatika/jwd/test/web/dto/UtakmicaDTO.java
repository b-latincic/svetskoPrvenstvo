package com.ftninformatika.jwd.test.web.dto;

import com.ftninformatika.jwd.test.model.Reprezentacija;

public class UtakmicaDTO {
	
	
	private Long id;
	
	private Long reprezentacijaAId;
	
	private Long reprezentacijaBId;
	
	

	private String repANaziv;
	
	private String repBNaziv;
	
	private int goloviA;
	
	private int goloviB;
	
	
	public Long getReprezentacijaAId() {
		return reprezentacijaAId;
	}

	public void setReprezentacijaAId(Long reprezentacijaAId) {
		this.reprezentacijaAId = reprezentacijaAId;
	}

	public Long getReprezentacijaBId() {
		return reprezentacijaBId;
	}

	public void setReprezentacijaBId(Long reprezentacijaBId) {
		this.reprezentacijaBId = reprezentacijaBId;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getRepANaziv() {
		return repANaziv;
	}

	public void setRepANaziv(String repANaziv) {
		this.repANaziv = repANaziv;
	}

	public String getRepBNaziv() {
		return repBNaziv;
	}

	public void setRepBNaziv(String repBNaziv) {
		this.repBNaziv = repBNaziv;
	}

	public int getGoloviA() {
		return goloviA;
	}

	public void setGoloviA(int goloviA) {
		this.goloviA = goloviA;
	}

	public int getGoloviB() {
		return goloviB;
	}

	public void setGoloviB(int goloviB) {
		this.goloviB = goloviB;
	}

	public UtakmicaDTO() {
		super();
	}
	
	
	

}
