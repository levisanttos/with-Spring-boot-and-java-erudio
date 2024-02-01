package br.com.erudio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.services.CalculationService;

@RestController
@RequestMapping("/maths")
public class MathController {
	
	
	@Autowired
	private CalculationService calculationService;
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)  {
		
		return this.calculationService.sum(numberOne, numberTwo);
	}
	
	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
		
		return this.calculationService.subtraction(numberOne, numberTwo);
	}
	
	@GetMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
		
		return this.calculationService.multiplication(numberOne, numberTwo);
	}
	
	@GetMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
		
		return this.calculationService.division(numberOne, numberTwo);
	}
	
	@GetMapping("/media/{numberOne}/{numberTwo}")
	public Double media(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
		
		return this.calculationService.media(numberOne, numberTwo);
	}
	
	@GetMapping("/square/{number}")
	public Double square(@PathVariable(value = "number") String number) {
		
		return this.calculationService.square(number);
	}
	


	

}
