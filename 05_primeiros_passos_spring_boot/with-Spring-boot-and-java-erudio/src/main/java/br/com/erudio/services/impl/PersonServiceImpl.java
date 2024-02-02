package br.com.erudio.services.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import br.com.erudio.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	private Logger logger = Logger.getLogger(PersonServiceImpl.class.getName());

	
	@Override
	public Person findById(Long id) {
		
		logger.info("Find one Person");
		
		return this.personRepository.findById(id).map(person ->{
			
			return person;
		}).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada.."));
	}
	
	@Override
	public List<Person> findAll() {
		return this.personRepository.findAll();
	}
	
	@Override
	public Person create(Person person) {
		
		logger.info("Criando um person");
		person = this.personRepository.save(person);
		logger.info("Pessoa criada com sucesso.");
		return person;
	}
	
	@Override
	public Person update(Long id, Person person) {
		logger.info("Atualizando o person");
		
		var entity = this.personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		person = this.personRepository.saveAndFlush(entity);
		logger.info("Pessoa atualizada com sucesso.");
		return person;
	}
	
	@Override
	public void delete(Long id) {
		logger.info("Removendo um person");
		var entity = this.personRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Pessoa não encontrada"));
		this.personRepository.delete(entity);
		logger.info("Pessoa removida com sucesso");
		
	}
}
