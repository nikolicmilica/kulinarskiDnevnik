package com.example.kulinarskiDnevnik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.kulinarskiDnevnik.model.Omiljenirecept;

public interface OmiljeniReceptJpaRepo extends JpaRepository<Omiljenirecept, Integer>{
	@Query("select r from Omiljenirecept r where r.receptBean.idRecept=:idRecept and r.omiljenakat.korisnikBean.idKorisnik=:idkorisnik")
	Omiljenirecept omiljenReceptKorisnika(@Param("idRecept")int idr, @Param("idkorisnik")int idk);
}
