package com.example.kulinarskiDnevnik.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	private String ime;

	private String password;

	private String prezime;

	private String username;

	//bi-directional many-to-one association to Omiljenakat
	@OneToMany(mappedBy="korisnikBean")
	private List<Omiljenakat> omiljenakats;

	//bi-directional many-to-one association to Poruka
	@OneToMany(mappedBy="korisnik1")
	private List<Poruka> porukas1;

	//bi-directional many-to-one association to Poruka
	@OneToMany(mappedBy="korisnik2")
	private List<Poruka> porukas2;

	//bi-directional many-to-one association to Recept
	@OneToMany(mappedBy="korisnikBean")
	private List<Recept> recepts;

	//bi-directional many-to-one association to Zahtev
	@OneToMany(mappedBy="korisnik1")
	private List<Zahtev> zahtevs1;

	//bi-directional many-to-one association to Zahtev
	@OneToMany(mappedBy="korisnik2")
	private List<Zahtev> zahtevs2;

	//bi-directional many-to-one association to Ulogakorisnika
	@ManyToOne
	@JoinColumn(name="uloga")
	private Ulogakorisnika ulogakorisnika;

	public Korisnik() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Omiljenakat> getOmiljenakats() {
		return this.omiljenakats;
	}

	public void setOmiljenakats(List<Omiljenakat> omiljenakats) {
		this.omiljenakats = omiljenakats;
	}

	public Omiljenakat addOmiljenakat(Omiljenakat omiljenakat) {
		getOmiljenakats().add(omiljenakat);
		omiljenakat.setKorisnikBean(this);

		return omiljenakat;
	}

	public Omiljenakat removeOmiljenakat(Omiljenakat omiljenakat) {
		getOmiljenakats().remove(omiljenakat);
		omiljenakat.setKorisnikBean(null);

		return omiljenakat;
	}

	public List<Poruka> getPorukas1() {
		return this.porukas1;
	}

	public void setPorukas1(List<Poruka> porukas1) {
		this.porukas1 = porukas1;
	}

	public Poruka addPorukas1(Poruka porukas1) {
		getPorukas1().add(porukas1);
		porukas1.setKorisnik1(this);

		return porukas1;
	}

	public Poruka removePorukas1(Poruka porukas1) {
		getPorukas1().remove(porukas1);
		porukas1.setKorisnik1(null);

		return porukas1;
	}

	public List<Poruka> getPorukas2() {
		return this.porukas2;
	}

	public void setPorukas2(List<Poruka> porukas2) {
		this.porukas2 = porukas2;
	}

	public Poruka addPorukas2(Poruka porukas2) {
		getPorukas2().add(porukas2);
		porukas2.setKorisnik2(this);

		return porukas2;
	}

	public Poruka removePorukas2(Poruka porukas2) {
		getPorukas2().remove(porukas2);
		porukas2.setKorisnik2(null);

		return porukas2;
	}

	public List<Recept> getRecepts() {
		return this.recepts;
	}

	public void setRecepts(List<Recept> recepts) {
		this.recepts = recepts;
	}

	public Recept addRecept(Recept recept) {
		getRecepts().add(recept);
		recept.setKorisnikBean(this);

		return recept;
	}

	public Recept removeRecept(Recept recept) {
		getRecepts().remove(recept);
		recept.setKorisnikBean(null);

		return recept;
	}

	public List<Zahtev> getZahtevs1() {
		return this.zahtevs1;
	}

	public void setZahtevs1(List<Zahtev> zahtevs1) {
		this.zahtevs1 = zahtevs1;
	}

	public Zahtev addZahtevs1(Zahtev zahtevs1) {
		getZahtevs1().add(zahtevs1);
		zahtevs1.setKorisnik1(this);

		return zahtevs1;
	}

	public Zahtev removeZahtevs1(Zahtev zahtevs1) {
		getZahtevs1().remove(zahtevs1);
		zahtevs1.setKorisnik1(null);

		return zahtevs1;
	}

	public List<Zahtev> getZahtevs2() {
		return this.zahtevs2;
	}

	public void setZahtevs2(List<Zahtev> zahtevs2) {
		this.zahtevs2 = zahtevs2;
	}

	public Zahtev addZahtevs2(Zahtev zahtevs2) {
		getZahtevs2().add(zahtevs2);
		zahtevs2.setKorisnik2(this);

		return zahtevs2;
	}

	public Zahtev removeZahtevs2(Zahtev zahtevs2) {
		getZahtevs2().remove(zahtevs2);
		zahtevs2.setKorisnik2(null);

		return zahtevs2;
	}

	public Ulogakorisnika getUlogakorisnika() {
		return this.ulogakorisnika;
	}

	public void setUlogakorisnika(Ulogakorisnika ulogakorisnika) {
		this.ulogakorisnika = ulogakorisnika;
	}

}