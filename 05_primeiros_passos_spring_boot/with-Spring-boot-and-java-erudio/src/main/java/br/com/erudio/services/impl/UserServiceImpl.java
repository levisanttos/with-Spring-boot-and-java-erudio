package br.com.erudio.services.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.erudio.repositories.UserRepository;
import br.com.erudio.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	

	private Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Buscando usuario pelo nome: "+ username);
		var user = this.userRepository.findByUsername(username);
		
		if (username != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("Usuario " + username + " não encontrado!");
		}
		
	}

}
