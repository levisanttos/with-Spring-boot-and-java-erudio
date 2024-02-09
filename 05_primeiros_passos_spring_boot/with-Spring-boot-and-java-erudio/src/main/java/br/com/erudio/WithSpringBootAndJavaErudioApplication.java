package br.com.erudio;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WithSpringBootAndJavaErudioApplication {

	public static void main(String[] args) {
		SpringApplication.run(WithSpringBootAndJavaErudioApplication.class, args);
		
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("pbkdf2", new BCryptPasswordEncoder());
		DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
		passwordEncoder.setDefaultPasswordEncoderForMatches(new BCryptPasswordEncoder());
		
		String result = passwordEncoder.encode("admin1234");
		
		System.out.println("My hash " + result);
	}

}
