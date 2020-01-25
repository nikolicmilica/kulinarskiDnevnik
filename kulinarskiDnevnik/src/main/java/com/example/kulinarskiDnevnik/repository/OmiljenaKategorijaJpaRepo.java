package com.example.kulinarskiDnevnik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kulinarskiDnevnik.model.Korisnik;
import com.example.kulinarskiDnevnik.model.Omiljenakat;

public interface OmiljenaKategorijaJpaRepo extends JpaRepository<Omiljenakat, Integer>{
	
	List<Omiljenakat> findByKorisnikBean(Korisnik k);
}
