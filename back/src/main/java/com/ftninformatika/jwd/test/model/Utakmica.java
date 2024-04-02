package com.ftninformatika.jwd.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Utakmica {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
	private Reprezentacija reprezentacijaA;
	
    @ManyToOne
    private Reprezentacija reprezentacijaB;
	
	@Column
	private int goloviA;
	
	
	@Column
	private int goloviB;


	
	
	public Utakmica() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Reprezentacija getReprezentacijaA() {
		return reprezentacijaA;
	}


	public void setReprezentacijaA(Reprezentacija reprezentacijaA) {
		this.reprezentacijaA = reprezentacijaA;
	}


	public Reprezentacija getReprezentacijaB() {
		return reprezentacijaB;
	}


	public void setReprezentacijaB(Reprezentacija reprezentacijaB) {
		this.reprezentacijaB = reprezentacijaB;
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


	@Override
	public String toString() {
		return "Utakmica [id=" + id + ", reprezentacijaA=" + reprezentacijaA.getNaziv() + ", reprezentacijaB=" + reprezentacijaB.getNaziv()
				+ ", goloviA=" + goloviA + ", goloviB=" + goloviB + "]";
	}
	
	
	
	
	
}
