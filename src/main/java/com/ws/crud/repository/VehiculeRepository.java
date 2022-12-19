package com.ws.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.crud.model.Vehicule;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long>{

}
