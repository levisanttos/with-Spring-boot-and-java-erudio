package br.com.erudio.data.vo.v1;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.erudio.model.Gender;

@JsonPropertyOrder(value = {"id","firstName","lastName", "address", "gender"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "id")
	private Long key;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private Gender gender;
	
	public PersonVO() {
		
	}
	

	public PersonVO(Long key, String firstName, String lastName, String address, Gender gender) {
		super();
		this.key = key;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
}
