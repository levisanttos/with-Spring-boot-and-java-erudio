package br.com.erudio.services.impl;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.ModelMapperUtil;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import br.com.erudio.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	private Logger logger = Logger.getLogger(PersonServiceImpl.class.getName());

	
	@Override
	public PersonVO findById(Long id) {
		
		logger.info("Find one Person");
		
		return this.personRepository.findById(id).map(person ->{
			PersonVO personVO = ModelMapperUtil.parseObject(person, PersonVO.class);
			return personVO;
		}).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada.."));
	}
	
	@Override
	public List<PersonVO> findAll() {
		return this.personRepository.findAll().stream().map(person -> {
			PersonVO personVO = ModelMapperUtil.parseObject(person, PersonVO.class);
			return personVO;
		}).collect(Collectors.toList());
	}
	
	@Override
	public PersonVO create(PersonVO personVO) {
		
		logger.info("Criando um person");
		
		Person person = ModelMapperUtil.parseObject(personVO, Person.class);
		
		person = this.personRepository.save(person);
		personVO.setId(person.getId());
		logger.info("Pessoa criada com sucesso.");
		
		return personVO;
	}
	
	@Override
	public PersonVO update(Long id, PersonVO personVO) {
		logger.info("Atualizando o person");
		
		var entity = this.personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));
		entity = ModelMapperUtil.parseObject(personVO, Person.class);
		entity = this.personRepository.saveAndFlush(entity);
		logger.info("Pessoa atualizada com sucesso.");
		return personVO;
	}
	
	@Override
	public void delete(Long id) {
		logger.info("Removendo um person");
		var entity = this.personRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Pessoa não encontrada"));
		this.personRepository.delete(entity);
		logger.info("Pessoa removida com sucesso");
		
	}
}
