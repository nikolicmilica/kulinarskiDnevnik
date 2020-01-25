package com.example.kulinarskiDnevnik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.kulinarskiDnevnik.model.Poruka;

public interface PorukaJpaRepo extends JpaRepository<Poruka, Integer>{
	@Query("SELECT p FROM Poruka p WHERE p.korisnik1.idKorisnik= :k1 AND p.korisnik2.idKorisnik= :k2 OR p.korisnik1.idKorisnik= :k2 AND p.korisnik2.idKorisnik= :k1 order by p.datumSlanja")
	List<Poruka> svePorukeKorisnika(@Param("k1")int k1, @Param("k2") int k2);
	
	@Query("SELECT p FROM Poruka p WHERE p.korisnik2.idKorisnik= :idk AND p.status='neprocitana' ")
	List<Poruka> neprocitanePorukeKorisnika(@Param("idk")int idKorisnik);
	
	@Query("SELECT p FROM Poruka p WHERE p.korisnik2.idKorisnik= :idk group by p.korisnik1 ")
	List<Poruka> primljenePorukePoKorisniku(@Param("idk") int idKorisnik);
}
