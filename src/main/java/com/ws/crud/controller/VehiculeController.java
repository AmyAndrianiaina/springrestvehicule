package com.ws.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.crud.exception.ResourceNotFoundException;
import com.ws.crud.model.Vehicule;
import com.ws.crud.repository.VehiculeRepository;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/rest/")
public class VehiculeController {
	
	@Autowired
	private VehiculeRepository vehiculeRepository;
	
	// get vehicules
	
	@GetMapping("vehicules")
	public List<Vehicule> getAllVehicule(){
		return this.vehiculeRepository.findAll();
	}
	
	// get vehicule by id
	
	@GetMapping("/vehicules/{id}")
	public ResponseEntity<Vehicule> getVehiculeById(@PathVariable(value = "id") Long vehiculeId)
			throws ResourceNotFoundException {
		Vehicule vehicule = vehiculeRepository.findById(vehiculeId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicule not found for this id :: " + vehiculeId));
		return ResponseEntity.ok().body(vehicule);
	}
	
	// save vehicule
	
	@PostMapping("/vehicules")
	public Vehicule createVehicule(@RequestBody Vehicule vehicule) {
		return vehiculeRepository.save(vehicule);
	}
	
	// update vehicule
	
	@PutMapping("/vehicules/{id}")
	public ResponseEntity<Vehicule> updateVehicule(@PathVariable(value = "id") Long vehiculeId,
		 @RequestBody Vehicule vehiculeDetails) throws ResourceNotFoundException {
		Vehicule vehicule = vehiculeRepository.findById(vehiculeId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicule not found for this id :: " + vehiculeId));

		vehicule.setMarque(vehiculeDetails.getMarque());
		vehicule.setModel(vehiculeDetails.getModel());
		vehicule.setCouleur(vehiculeDetails.getCouleur());
		vehicule.setKm(vehiculeDetails.getKm());
		vehicule.setNumero(vehiculeDetails.getNumero());
		final Vehicule updatedVehicule = vehiculeRepository.save(vehicule);
		return ResponseEntity.ok(updatedVehicule);
	}
	
	// delete vehicule
	
	@DeleteMapping("/vehicules/{id}")
	public Map<String, Boolean> deleteVehicule(@PathVariable(value = "id") Long vehiculeId)
			throws ResourceNotFoundException {
		Vehicule vehicule = vehiculeRepository.findById(vehiculeId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicule not found for this id :: " + vehiculeId));

		vehiculeRepository.delete(vehicule);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
