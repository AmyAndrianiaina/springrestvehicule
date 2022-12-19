package com.ws.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.crud.exception.ResourceNotFoundException;
import com.ws.crud.model.Kilometrage;
import com.ws.crud.repository.KilometrageRepository;

@RestController
@RequestMapping("/rest/")
public class KilometrageController {
	
	@Autowired
	private KilometrageRepository kilometrageRepository;
	
	// get kilometrages
	
	@GetMapping("kilometrages")
	public List<Kilometrage> getAllKilometrage(){
		return this.kilometrageRepository.findAll();
	}
	
	// get kilometrage by id
	
	@GetMapping("/kilometrages/{id}")
	public ResponseEntity<Kilometrage> getKilometrageById(@PathVariable(value = "id") Long kilometrageId)
			throws ResourceNotFoundException {
		Kilometrage kilometrage = kilometrageRepository.findById(kilometrageId)
				.orElseThrow(() -> new ResourceNotFoundException("Kilometrage not found for this id :: " + kilometrageId));
		return ResponseEntity.ok().body(kilometrage);
	}
	
	// save kilometrage
	
	@PostMapping("/kilometrages")
	public Kilometrage createKilometrage(@RequestBody Kilometrage kilometrage) {
		return kilometrageRepository.save(kilometrage);
	}
	
	// update kilometrage
	
	@PutMapping("/kilometrages/{id}")
	public ResponseEntity<Kilometrage> updateKilometrage(@PathVariable(value = "id") Long kilometrageId,
		 @RequestBody Kilometrage kilometrageDetails) throws ResourceNotFoundException {
		Kilometrage kilometrage = kilometrageRepository.findById(kilometrageId)
				.orElseThrow(() -> new ResourceNotFoundException("Kilometrage not found for this id :: " + kilometrageId));

		kilometrage.setIdVehicule(kilometrageDetails.getIdVehicule());
		kilometrage.setDate(kilometrageDetails.getDate());
		kilometrage.setDebutKm(kilometrageDetails.getDebutKm());
		kilometrage.setFinKm(kilometrageDetails.getFinKm());
		final Kilometrage updatedKilometrage = kilometrageRepository.save(kilometrage);
		return ResponseEntity.ok(updatedKilometrage);
	}
	
	// delete kilometrage
	
	@DeleteMapping("/kilometrages/{id}")
	public Map<String, Boolean> deleteKilometrage(@PathVariable(value = "id") Long kilometrageId)
			throws ResourceNotFoundException {
		Kilometrage kilometrage = kilometrageRepository.findById(kilometrageId)
				.orElseThrow(() -> new ResourceNotFoundException("Kilometrage not found for this id :: " + kilometrageId));

		kilometrageRepository.delete(kilometrage);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
