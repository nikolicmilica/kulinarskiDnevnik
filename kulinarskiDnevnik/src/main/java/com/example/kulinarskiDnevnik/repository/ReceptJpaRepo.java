package com.example.kulinarskiDnevnik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kulinarskiDnevnik.model.Recept;

public interface ReceptJpaRepo extends JpaRepository<Recept, Integer>{
	
}
