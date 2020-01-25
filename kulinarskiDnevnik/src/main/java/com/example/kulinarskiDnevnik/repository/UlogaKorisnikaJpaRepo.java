package com.example.kulinarskiDnevnik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kulinarskiDnevnik.model.Ulogakorisnika;

public interface UlogaKorisnikaJpaRepo extends JpaRepository<Ulogakorisnika, Integer>{
	
	Ulogakorisnika findByNazivUloge(String naziv);
}
