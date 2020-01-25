package com.example.kulinarskiDnevnik.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the poruka database table.
 * 
 */
@Entity
@NamedQuery(name="Poruka.findAll", query="SELECT p FROM Poruka p")
public class Poruka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPoruka;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datumSlanja;

	private String status;

	private String text;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnikPoslao")
	private Korisnik korisnik1;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnikPrimio")
	private Korisnik korisnik2;

	public Poruka() {
	}

	public int getIdPoruka() {
		return this.idPoruka;
	}

	public void setIdPoruka(int idPoruka) {
		this.idPoruka = idPoruka;
	}

	public Date getDatumSlanja() {
		return this.datumSlanja;
	}

	public void setDatumSlanja(Date datumSlanja) {
		this.datumSlanja = datumSlanja;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Korisnik getKorisnik1() {
		return this.korisnik1;
	}

	public void setKorisnik1(Korisnik korisnik1) {
		this.korisnik1 = korisnik1;
	}

	public Korisnik getKorisnik2() {
		return this.korisnik2;
	}

	public void setKorisnik2(Korisnik korisnik2) {
		this.korisnik2 = korisnik2;
	}

}