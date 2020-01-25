package com.example.kulinarskiDnevnik.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the recept database table.
 * 
 */
@Entity
@NamedQuery(name="Recept.findAll", query="SELECT r FROM Recept r")
public class Recept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRecept;

	@Temporal(TemporalType.DATE)
	private Date datumPostavke;

	private String nacinPripreme;

	private String naziv;

	//bi-directional many-to-many association to Omiljenakat
	@ManyToMany(mappedBy="recepts")
	private List<Omiljenakat> omiljenakats;

	//bi-directional many-to-one association to Omiljenirecept
	@OneToMany(mappedBy="receptBean")
	private List<Omiljenirecept> omiljenirecepts;

	//bi-directional many-to-one association to Kategorija
	@ManyToOne
	@JoinColumn(name="kategorija")
	private Kategorija kategorijaBean;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnik")
	private Korisnik korisnikBean;

	//bi-directional many-to-one association to Sastojak
	@OneToMany(mappedBy="receptBean")
	private List<Sastojak> sastojaks;

	//bi-directional many-to-one association to Slika
	@OneToMany(mappedBy="receptBean")
	private List<Slika> slikas;

	public Recept() {
	}

	public int getIdRecept() {
		return this.idRecept;
	}

	public void setIdRecept(int idRecept) {
		this.idRecept = idRecept;
	}

	public Date getDatumPostavke() {
		return this.datumPostavke;
	}

	public void setDatumPostavke(Date datumPostavke) {
		this.datumPostavke = datumPostavke;
	}

	public String getNacinPripreme() {
		return this.nacinPripreme;
	}

	public void setNacinPripreme(String nacinPripreme) {
		this.nacinPripreme = nacinPripreme;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Omiljenakat> getOmiljenakats() {
		return this.omiljenakats;
	}

	public void setOmiljenakats(List<Omiljenakat> omiljenakats) {
		this.omiljenakats = omiljenakats;
	}

	public List<Omiljenirecept> getOmiljenirecepts() {
		return this.omiljenirecepts;
	}

	public void setOmiljenirecepts(List<Omiljenirecept> omiljenirecepts) {
		this.omiljenirecepts = omiljenirecepts;
	}

	public Omiljenirecept addOmiljenirecept(Omiljenirecept omiljenirecept) {
		getOmiljenirecepts().add(omiljenirecept);
		omiljenirecept.setReceptBean(this);

		return omiljenirecept;
	}

	public Omiljenirecept removeOmiljenirecept(Omiljenirecept omiljenirecept) {
		getOmiljenirecepts().remove(omiljenirecept);
		omiljenirecept.setReceptBean(null);

		return omiljenirecept;
	}

	public Kategorija getKategorijaBean() {
		return this.kategorijaBean;
	}

	public void setKategorijaBean(Kategorija kategorijaBean) {
		this.kategorijaBean = kategorijaBean;
	}

	public Korisnik getKorisnikBean() {
		return this.korisnikBean;
	}

	public void setKorisnikBean(Korisnik korisnikBean) {
		this.korisnikBean = korisnikBean;
	}

	public List<Sastojak> getSastojaks() {
		return this.sastojaks;
	}

	public void setSastojaks(List<Sastojak> sastojaks) {
		this.sastojaks = sastojaks;
	}

	public Sastojak addSastojak(Sastojak sastojak) {
		getSastojaks().add(sastojak);
		sastojak.setReceptBean(this);

		return sastojak;
	}

	public Sastojak removeSastojak(Sastojak sastojak) {
		getSastojaks().remove(sastojak);
		sastojak.setReceptBean(null);

		return sastojak;
	}

	public List<Slika> getSlikas() {
		return this.slikas;
	}

	public void setSlikas(List<Slika> slikas) {
		this.slikas = slikas;
	}

	public Slika addSlika(Slika slika) {
		getSlikas().add(slika);
		slika.setReceptBean(this);

		return slika;
	}

	public Slika removeSlika(Slika slika) {
		getSlikas().remove(slika);
		slika.setReceptBean(null);

		return slika;
	}

}