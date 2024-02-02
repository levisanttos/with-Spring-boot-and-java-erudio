package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	
	@Autowired
	private PersonService personService;

	
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<Person>(this.personService.findById(id), HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Person>> getPersons() {
		return new ResponseEntity<List<Person>>(this.personService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Person> save(@RequestBody Person person) {
		return new ResponseEntity<Person>(this.personService.create(person), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Person> update(@PathVariable(value = "id") Long id,@RequestBody Person person) {
		return new ResponseEntity<Person>(this.personService.update(id,person), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
		this.personService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
