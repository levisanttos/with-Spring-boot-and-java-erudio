package br.com.erudio.services;

import java.util.List;

import br.com.erudio.model.Person;

public interface PersonService {

	
	Person findById(Long id);
	
	List<Person> findAll();
	
	Person create(Person person);
	
	Person update(Long id, Person person);
	
	void delete(Long id);
	
}
