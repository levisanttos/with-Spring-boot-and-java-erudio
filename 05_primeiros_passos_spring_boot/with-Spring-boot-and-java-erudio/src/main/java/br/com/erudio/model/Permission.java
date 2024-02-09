package br.com.erudio.model;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "permission")
@Entity
public class Permission implements Serializable, GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2482973639537299619L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" )
	private Long id;
	
	@Column(name = "description")
	private String description;

	public Permission() {
		
	}
	
	public Permission(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getAuthority() {
		return this.description;
	}

	
}
