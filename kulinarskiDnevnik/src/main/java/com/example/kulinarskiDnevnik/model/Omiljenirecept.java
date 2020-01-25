package com.example.kulinarskiDnevnik.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the omiljenirecept database table.
 * 
 */
@Entity
@NamedQuery(name="Omiljenirecept.findAll", query="SELECT o FROM Omiljenirecept o")
public class Omiljenirecept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOmiljeniRecept;

	//bi-directional many-to-one association to Omiljenakat
	@ManyToOne
	@JoinColumn(name="omiljenaKat")
	private Omiljenakat omiljenakat;

	//bi-directional many-to-one association to Recept
	@ManyToOne
	@JoinColumn(name="recept")
	private Recept receptBean;

	public Omiljenirecept() {
	}

	public int getIdOmiljeniRecept() {
		return this.idOmiljeniRecept;
	}

	public void setIdOmiljeniRecept(int idOmiljeniRecept) {
		this.idOmiljeniRecept = idOmiljeniRecept;
	}

	public Omiljenakat getOmiljenakat() {
		return this.omiljenakat;
	}

	public void setOmiljenakat(Omiljenakat omiljenakat) {
		this.omiljenakat = omiljenakat;
	}

	public Recept getReceptBean() {
		return this.receptBean;
	}

	public void setReceptBean(Recept receptBean) {
		this.receptBean = receptBean;
	}

}