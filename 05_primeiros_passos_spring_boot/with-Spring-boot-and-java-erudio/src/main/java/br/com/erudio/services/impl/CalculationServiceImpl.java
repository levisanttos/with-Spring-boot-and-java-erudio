package br.com.erudio.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.services.CalculationService;
import br.com.erudio.validators.Validator;

@Service
public class CalculationServiceImpl implements CalculationService {

	
	@Autowired
	private Validator validator;
	
	@Override
	public double sum(String numberOne, String numberTwo) {
		
		if (!validator.isNumeric(numberOne) || !validator.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Valores invalidos, os parametros devem ser númericos...");
		}
		return validator.convertDouble(numberOne) + validator.convertDouble(numberTwo);
	}

	@Override
	public double subtraction(String numberOne, String numberTwo) {
		if (!validator.isNumeric(numberOne) || !validator.isNumeric(numberTwo)) {
			
			throw new UnsupportedMathOperationException("Valores invalidos, os parametros devem ser númericos...");
		}
		
		return validator.convertDouble(numberOne) - validator.convertDouble(numberTwo);
	}

	@Override
	public double multiplication(String numberOne, String numberTwo) {
		
		if (!validator.isNumeric(numberOne) || !validator.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Valores invalidos, os parametros devem ser númericos...");
		}
		
		return validator.convertDouble(numberOne) * validator.convertDouble(numberTwo);
	}

	@Override
	public double division(String numberOne, String numberTwo) {
		
		if (!validator.isNumeric(numberOne) || !validator.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Valores invalidos, os parametros devem ser númericos...");
		}
		
		return validator.convertDouble(numberOne) / validator.convertDouble(numberTwo);
	}

	@Override
	public double media(String numberOne, String numberTwo) {
		
		if (!validator.isNumeric(numberOne) || !validator.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Valores invalidos, os parametros devem ser númericos...");
		}
		
		return ( validator.convertDouble(numberOne) + validator.convertDouble(numberTwo) ) / 2;
	}

	@Override
	public double square(String number) {
		
		if (!validator.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Valores invalidos, os parametros devem ser númericos...");
		}
		
		return Math.sqrt( validator.convertDouble(number));
	}

}
