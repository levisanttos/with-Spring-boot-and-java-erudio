package br.com.erudio.services.impl;

import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import br.com.erudio.services.PersonService;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

	MockPeson input;
	
	@InjectMocks
	private PersonServiceImpl service;
	
	@InjectMocks
	private PersonRepository personRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		input = new MockPeson();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindById() {
		
		Person person = input.mockEntity();
		person.setId(1L);
		
		Mockito.when(personRepository.findById(1L)).thenReturn(Optional.of(person));
		
		var resultado = this.service.findById(1L);
		Assertions.assertNotNull(resultado);
		
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateV2() {
		fail("Not yet implemented");
	}

}
