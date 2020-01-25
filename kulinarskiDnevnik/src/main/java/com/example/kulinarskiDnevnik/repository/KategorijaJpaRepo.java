package com.example.kulinarskiDnevnik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kulinarskiDnevnik.model.Kategorija;

public interface KategorijaJpaRepo extends JpaRepository<Kategorija, Integer>{

}
