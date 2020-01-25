package com.example.kulinarskiDnevnik.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ulogakorisnika database table.
 * 
 */
@Entity
@NamedQuery(name="Ulogakorisnika.findAll", query="SELECT u FROM Ulogakorisnika u")
public class Ulogakorisnika implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUloga;

	private String nazivUloge;

	//bi-directional many-to-one association to Korisnik
	@OneToMany(mappedBy="ulogakorisnika")
	private List<Korisnik> korisniks;

	public Ulogakorisnika() {
	}

	public int getIdUloga() {
		return this.idUloga;
	}

	public void setIdUloga(int idUloga) {
		this.idUloga = idUloga;
	}

	public String getNazivUloge() {
		return this.nazivUloge;
	}

	public void setNazivUloge(String nazivUloge) {
		this.nazivUloge = nazivUloge;
	}

	public List<Korisnik> getKorisniks() {
		return this.korisniks;
	}

	public void setKorisniks(List<Korisnik> korisniks) {
		this.korisniks = korisniks;
	}

	public Korisnik addKorisnik(Korisnik korisnik) {
		getKorisniks().add(korisnik);
		korisnik.setUlogakorisnika(this);

		return korisnik;
	}

	public Korisnik removeKorisnik(Korisnik korisnik) {
		getKorisniks().remove(korisnik);
		korisnik.setUlogakorisnika(null);

		return korisnik;
	}

}