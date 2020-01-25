package com.example.kulinarskiDnevnik.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the zahtev database table.
 * 
 */
@Entity
@NamedQuery(name="Zahtev.findAll", query="SELECT z FROM Zahtev z")
public class Zahtev implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZahtev;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datum;

	private String status;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnikPrima")
	private Korisnik korisnik1;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnikSalje")
	private Korisnik korisnik2;

	public Zahtev() {
	}

	public int getIdZahtev() {
		return this.idZahtev;
	}

	public void setIdZahtev(int idZahtev) {
		this.idZahtev = idZahtev;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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