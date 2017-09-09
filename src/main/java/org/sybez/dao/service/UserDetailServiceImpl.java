package org.sybez.dao.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.sybez.dao.entity.Client;
import org.sybez.dao.repository.ClientRepository;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	ClientRepository clientRepository;
	
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		Client client = clientRepository.findByName(login);
		if (client==null){
			return null;
	}
		Collection<SimpleGrantedAuthority> authority = new ArrayList<SimpleGrantedAuthority>();
		authority.add(new SimpleGrantedAuthority(client.getUserRole().toString()));
		return new User(String.valueOf(client.getId()), client.getPassword(),authority);

}
}
