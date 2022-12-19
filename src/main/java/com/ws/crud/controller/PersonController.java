package com.ws.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.ws.crud.model.Person;
import com.ws.crud.repository.PersonRepository;
import com.ws.crud.response.ResponseHandler;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/rest/")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	// get persons
	
//	@GetMapping("persons")
//	public ResponseEntity<Object> getAllPerson(){
//		return ResponseHandler.responseBuilder(HttpStatus.OK, this.personRepository.findAll());
//	}
	
	@GetMapping("persons")
	public List<Person> getAllPerson(){
		return this.personRepository.findAll();
	}
	
	
	// get person by id 
	
	@GetMapping("/persons/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personId)
			throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
		return ResponseEntity.ok().body(person);
	}
	
	// save person
	
	@PostMapping("/persons")
	public Person createPerson(@RequestBody Person person) {
		return personRepository.save(person);
	}
	
	// update person
	
	@PutMapping("/persons/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId,
		 @RequestBody Person personDetails) throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

		person.setNom(personDetails.getNom());
		person.setPrenom(personDetails.getPrenom());
		final Person updatedPerson = personRepository.save(person);
		return ResponseEntity.ok(updatedPerson);
	}
	
	// delete person
	
	@DeleteMapping("/persons/{id}")
	public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personId)
			throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

		personRepository.delete(person);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
