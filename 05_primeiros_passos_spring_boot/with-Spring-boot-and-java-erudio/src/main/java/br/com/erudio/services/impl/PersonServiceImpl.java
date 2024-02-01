package br.com.erudio.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonServiceImpl.class.getName());

	
	@Override
	public Person findById(String id) {
		
		logger.info("Find one Person");
		
		Person person = new Person(counter.incrementAndGet(), "Levi", "Santos", "Taboão da Serra - SP - Brasil", "MASCULINO");
		
		return person;
	}
	
	@Override
	public List<Person> findAll() {
		
		logger.info("Retornando uma lista de persons");
		
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(counter.incrementAndGet(), "Levi", "Santos", "Taboão da Serra", "MASCULINO"));
		persons.add(new Person(counter.incrementAndGet(), "Artur", "Santos", "Madrid - Spain", "MASCULINO"));
		persons.add(new Person(counter.incrementAndGet(), "Vitor", "Santos", "Manchester - Inglaterra", "MASCULINO"));
		persons.add(new Person(counter.incrementAndGet(), "Italo", "Santos", "Munique - Germany", "MASCULINO"));
		persons.add(new Person(counter.incrementAndGet(), "Wanessa", "Ribeiro", "Africa do Sul", "Feminino"));
		persons.add(new Person(counter.incrementAndGet(), "Perola", "Santos", "Milão - Italia", "Feminino"));
		return persons;
	}
	
	@Override
	public Person create(Person person) {
		
		logger.info("Criando um person");
		return person;
	}
	
	@Override
	public Person update(Person person) {
		logger.info("Atualizando o person");
		return person;
	}
	
	@Override
	public void delete(String id) {
		logger.info("Removendo um person");
		
	}
}
