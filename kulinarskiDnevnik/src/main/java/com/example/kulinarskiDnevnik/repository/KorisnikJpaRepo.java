package com.example.kulinarskiDnevnik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kulinarskiDnevnik.model.Korisnik;

public interface KorisnikJpaRepo extends JpaRepository<Korisnik, Integer>{
	
	Korisnik findByUsernameAndPassword(String username, String password);
	Korisnik findByUsername(String username);

}
