package br.com.erudio.services;

import java.util.List;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;

public interface PersonService {

	
	PersonVO findById(Long id);
	
	List<PersonVO> findAll();
	
	PersonVO create(PersonVO personVO);
	
	PersonVO update(Long id, PersonVO personVO);
	
	void delete(Long id);

	PersonVOV2 createV2(PersonVOV2 personVOV2);
	
}
