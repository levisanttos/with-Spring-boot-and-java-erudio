package br.com.erudio.services.impl;

import java.time.LocalDate;

import br.com.erudio.model.Gender;
import br.com.erudio.model.Person;

public class MockPeson {

	
	public Person mockEntity() {
		Person person = new Person();
		person.setAddress("Taboão da Serra");
		person.setBirthDay(LocalDate.now());
		person.setFirstName("Levi");
		person.setLastName("Santos");
		person.setGender(Gender.MASCULINO);
		return person;
	}
}
