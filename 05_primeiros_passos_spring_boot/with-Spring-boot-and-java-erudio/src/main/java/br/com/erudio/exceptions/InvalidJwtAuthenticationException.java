package br.com.erudio.exceptions;

import org.springframework.security.core.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 88379334640375114L;
	
	public InvalidJwtAuthenticationException(String message) {
		super(message);
	}

}
