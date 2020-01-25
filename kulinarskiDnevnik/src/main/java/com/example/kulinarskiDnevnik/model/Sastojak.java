package com.example.kulinarskiDnevnik.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sastojak database table.
 * 
 */
@Entity
@NamedQuery(name="Sastojak.findAll", query="SELECT s FROM Sastojak s")
public class Sastojak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSastojak;

	private String kolicina;

	private String sastojak;

	//bi-directional many-to-one association to Recept
	@ManyToOne
	@JoinColumn(name="recept")
	private Recept receptBean;

	public Sastojak() {
	}

	public int getIdSastojak() {
		return this.idSastojak;
	}

	public void setIdSastojak(int idSastojak) {
		this.idSastojak = idSastojak;
	}

	public String getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(String kolicina) {
		this.kolicina = kolicina;
	}

	public String getSastojak() {
		return this.sastojak;
	}

	public void setSastojak(String sastojak) {
		this.sastojak = sastojak;
	}

	public Recept getReceptBean() {
		return this.receptBean;
	}

	public void setReceptBean(Recept receptBean) {
		this.receptBean = receptBean;
	}

}