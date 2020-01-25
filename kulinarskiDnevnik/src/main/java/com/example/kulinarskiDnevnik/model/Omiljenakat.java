package com.example.kulinarskiDnevnik.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the omiljenakat database table.
 * 
 */
@Entity
@NamedQuery(name="Omiljenakat.findAll", query="SELECT o FROM Omiljenakat o")
public class Omiljenakat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOmiljenaKat;

	private String naziv;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnik")
	private Korisnik korisnikBean;

	//bi-directional many-to-many association to Recept
	@ManyToMany
	@JoinTable(
		name="omiljenirecept"
		, joinColumns={
			@JoinColumn(name="omiljenaKat")
			}
		, inverseJoinColumns={
			@JoinColumn(name="recept")
			}
		)
	private List<Recept> recepts;

	//bi-directional many-to-one association to Omiljenirecept
	@OneToMany(mappedBy="omiljenakat")
	private List<Omiljenirecept> omiljenirecepts;

	public Omiljenakat() {
	}

	public int getIdOmiljenaKat() {
		return this.idOmiljenaKat;
	}

	public void setIdOmiljenaKat(int idOmiljenaKat) {
		this.idOmiljenaKat = idOmiljenaKat;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Korisnik getKorisnikBean() {
		return this.korisnikBean;
	}

	public void setKorisnikBean(Korisnik korisnikBean) {
		this.korisnikBean = korisnikBean;
	}

	public List<Recept> getRecepts() {
		return this.recepts;
	}

	public void setRecepts(List<Recept> recepts) {
		this.recepts = recepts;
	}

	public List<Omiljenirecept> getOmiljenirecepts() {
		return this.omiljenirecepts;
	}

	public void setOmiljenirecepts(List<Omiljenirecept> omiljenirecepts) {
		this.omiljenirecepts = omiljenirecepts;
	}

	public Omiljenirecept addOmiljenirecept(Omiljenirecept omiljenirecept) {
		getOmiljenirecepts().add(omiljenirecept);
		omiljenirecept.setOmiljenakat(this);

		return omiljenirecept;
	}

	public Omiljenirecept removeOmiljenirecept(Omiljenirecept omiljenirecept) {
		getOmiljenirecepts().remove(omiljenirecept);
		omiljenirecept.setOmiljenakat(null);

		return omiljenirecept;
	}

}