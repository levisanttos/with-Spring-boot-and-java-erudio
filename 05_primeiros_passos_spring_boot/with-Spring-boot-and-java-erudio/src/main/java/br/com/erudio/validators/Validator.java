package br.com.erudio.validators;

import org.springframework.stereotype.Component;

@Component
public class Validator {

	
	public double convertDouble(String strNumber) {
		
		if (strNumber == null) {
			return 0D;
		}
		
		String number = strNumber.replaceAll(",", ".");
		
		if (!isNumeric(number)) {
			return 0D;
		}
		
		return Double.parseDouble(number);
	}
	
	public boolean isNumeric(String strNumber) {
        if (strNumber == null) {
        	return false; 
        }
        
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
