package com.ws.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.crud.model.Kilometrage;

@Repository
public interface KilometrageRepository extends JpaRepository<Kilometrage, Long>{

}
