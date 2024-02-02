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

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.services.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	
	@Autowired
	private PersonService personService;

	
	@GetMapping("/{id}")
	public ResponseEntity<PersonVO> getPerson(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<PersonVO>(this.personService.findById(id), HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<PersonVO>> getPersons() {
		return new ResponseEntity<List<PersonVO>>(this.personService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PersonVO> save(@RequestBody PersonVO personVO) {
		return new ResponseEntity<PersonVO>(this.personService.create(personVO), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PersonVO> update(@PathVariable(value = "id") Long id,@RequestBody PersonVO personVO) {
		return new ResponseEntity<PersonVO>(this.personService.update(id,personVO), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
		this.personService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
