package com.zezinho.security.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zezinho.security.Model.Usuario;
import com.zezinho.security.Repositorio.UsuarioRepositorio;

public class CustomUserServiceDetail implements UserDetailsService{
	
	@Autowired
	private UsuarioRepositorio userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario= userRepo.findbyName(username);
		if(usuario==null) {
			throw new  UsernameNotFoundException("Usuario não foi achado");
		}
		return new CustomUserDetail(usuario);
	}

	

}
