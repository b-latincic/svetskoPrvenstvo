package com.ftninformatika.jwd.test.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ReprezentacijaDTO {
	
	
	@Positive
	private Long id;
	
	@NotNull
	private String naziv;
	
	@Size(min = 3, max = 3)
	private String skraceniNaziv;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

	public ReprezentacijaDTO() {
		super();
	}
	
	
	
	
	
}
