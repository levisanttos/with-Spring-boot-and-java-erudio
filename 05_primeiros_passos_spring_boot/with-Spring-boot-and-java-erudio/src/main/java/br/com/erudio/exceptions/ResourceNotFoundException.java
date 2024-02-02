package br.com.erudio.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 88379334640375114L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
