package com.example.kulinarskiDnevnik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.kulinarskiDnevnik.model.Korisnik;
import com.example.kulinarskiDnevnik.model.Zahtev;

public interface ZahtevJpaRepo extends JpaRepository<Zahtev, Integer>{

	Zahtev findByKorisnik1AndKorisnik2(Korisnik korisnik1, Korisnik korisnik2);
	List<Zahtev> findByKorisnik1(Korisnik poslao);
	List<Zahtev> findByKorisnik2(Korisnik primio);
	
	@Query("SELECT z FROM Zahtev z WHERE z.korisnik1 =:korisnik OR z.korisnik2= :korisnik AND z.status='prihvacen'")
	List<Zahtev> prijateljiKorisnika(@Param("korisnik") Korisnik k);
}
