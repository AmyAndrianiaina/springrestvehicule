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
import com.ws.crud.model.Terrain;
import com.ws.crud.repository.TerrainRepository;

@RestController
@RequestMapping("/mine/")
public class TerrainController {
	
	@Autowired
	private TerrainRepository terrainRepository;
	
	// get terrains
	
	@GetMapping("terrains")
	public List<Terrain> getAllTerrain(){
		return this.terrainRepository.findAll();
	}
	
	// get terrain by id
	
	@GetMapping("/terrains/{id}")
	public ResponseEntity<Terrain> getTerrainById(@PathVariable(value = "id") Long terrainId)
			throws ResourceNotFoundException {
		Terrain terrain = terrainRepository.findById(terrainId)
				.orElseThrow(() -> new ResourceNotFoundException("Terrain not found for this id :: " + terrainId));
		return ResponseEntity.ok().body(terrain);
	}
	
	// save terrain
	
	@PostMapping("/terrains")
	public Terrain createTerrain(@RequestBody Terrain terrain) {
		return terrainRepository.save(terrain);
	}
	
	// update terrain
	
	@PutMapping("/terrains/{id}")
	public ResponseEntity<Terrain> updateTerrain(@PathVariable(value = "id") Long terrainId,
		 @RequestBody Terrain terrainDetails) throws ResourceNotFoundException {
		Terrain terrain = terrainRepository.findById(terrainId)
				.orElseThrow(() -> new ResourceNotFoundException("Terrain not found for this id :: " + terrainId));

		terrain.setPointDroiteHautX(terrainDetails.getPointDroiteHautX());
		terrain.setPointDroiteHautY(terrainDetails.getPointDroiteHautY());
		terrain.setPointDroiteBasX(terrainDetails.getPointDroiteBasX());
		terrain.setPointDroiteBasY(terrainDetails.getPointDroiteBasY());
		terrain.setPointGaucheHautX(terrainDetails.getPointGaucheHautX());
		terrain.setPointGaucheHautY(terrainDetails.getPointGaucheHautY());
		terrain.setPointGaucheBasX(terrainDetails.getPointGaucheBasX());
		terrain.setPointGaucheBasY(terrainDetails.getPointGaucheBasY());
		terrain.setArea(terrainDetails.getArea());
		final Terrain updatedTerrain = terrainRepository.save(terrain);
		return ResponseEntity.ok(updatedTerrain);
	}
	
	// delete terrain
	
	@DeleteMapping("/terrains/{id}")
	public Map<String, Boolean> deleteTerrain(@PathVariable(value = "id") Long terrainId)
			throws ResourceNotFoundException {
		Terrain terrain = terrainRepository.findById(terrainId)
				.orElseThrow(() -> new ResourceNotFoundException("Terrain not found for this id :: " + terrainId));

		terrainRepository.delete(terrain);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
