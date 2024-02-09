package br.com.erudio.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.authentication.AuthenticationManagerBeanDefinitionParser;
import org.springframework.security.config.authentication.AuthenticationManagerFactoryBean;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.erudio.security.jwt.JwtTokenProvider;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("pbkdf2", new BCryptPasswordEncoder());
		DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
		passwordEncoder.setDefaultPasswordEncoderForMatches(new BCryptPasswordEncoder());
		
		return passwordEncoder;
	}
	
	public AuthenticationManager authenticationManager() {
		return null;
	}
	
	public void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
			.httpBasic()
			.disable()
			.csrf()
			.disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests();
	}

}
