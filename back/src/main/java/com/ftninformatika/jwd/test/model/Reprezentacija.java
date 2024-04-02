package com.ftninformatika.jwd.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reprezentacija {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(unique = true, nullable = false)
	private String naziv;
	
    @Column(unique = true, nullable = false, length=3)
	private String skraceniNaziv;
	
	
    @OneToMany(mappedBy="reprezentacija", fetch= FetchType.EAGER)
	private List<Igrac> igraci = new ArrayList<>();


    
    
    
	public Reprezentacija() {
		super();
	}


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


	public List<Igrac> getIgraci() {
		return igraci;
	}


	public void setIgraci(List<Igrac> igraci) {
		this.igraci = igraci;
	}
    
    
	
}
