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
import com.ws.crud.model.Point;
import com.ws.crud.repository.PointRepository;

@RestController
@RequestMapping("/mine/")
public class PointController {
	
	@Autowired
	private PointRepository pointRepository;
	
	// get points
	
	@GetMapping("points")
	public List<Point> getAllPoint(){
		return this.pointRepository.findAll();
	}
	
	// get point by id
	
	@GetMapping("/points/{id}")
	public ResponseEntity<Point> getPointById(@PathVariable(value = "id") Long pointId)
			throws ResourceNotFoundException {
		Point point = pointRepository.findById(pointId)
				.orElseThrow(() -> new ResourceNotFoundException("Point not found for this id :: " + pointId));
		return ResponseEntity.ok().body(point);
	}
	
	// save point
	
	@PostMapping("/points")
	public Point createPoint(@RequestBody Point point) {
		return pointRepository.save(point);
	}
	
	// update point
	
	@PutMapping("/points/{id}")
	public ResponseEntity<Point> updatePoint(@PathVariable(value = "id") Long pointId,
		 @RequestBody Point pointDetails) throws ResourceNotFoundException {
		Point point = pointRepository.findById(pointId)
				.orElseThrow(() -> new ResourceNotFoundException("Point not found for this id :: " + pointId));

		point.setIdTerrain(pointDetails.getIdTerrain());
        point.setX(pointDetails.getX());
        point.setY(pointDetails.getY());
        point.setVatoKg(pointDetails.getVatoKg());
        point.setVolamenaKg(pointDetails.getVolamenaKg());
        point.setHeureTotal(pointDetails.getHeureTotal());
		point.setPourcentage(pointDetails.getPourcentage());
		point.setPerformanceParHeure(pointDetails.getPerformanceParHeure());
		final Point updatedPoint = pointRepository.save(point);
		return ResponseEntity.ok(updatedPoint);
	}
	
	// delete point
	
	@DeleteMapping("/points/{id}")
	public Map<String, Boolean> deletePoint(@PathVariable(value = "id") Long pointId)
			throws ResourceNotFoundException {
		Point point = pointRepository.findById(pointId)
				.orElseThrow(() -> new ResourceNotFoundException("Point not found for this id :: " + pointId));

		pointRepository.delete(point);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
