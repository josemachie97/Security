package com.zezinho.security.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zezinho.security.Model.Usuario;
import com.zezinho.security.Repositorio.UsuarioRepositorio;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepositorio userRepositorio;
	
	@GetMapping("/")
	public ModelAndView index() {
	ModelAndView mv= new ModelAndView();
	mv.setViewName("usuario/main");
	return mv;
		
	}

	@GetMapping("usuario")
		public ModelAndView user() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("usuario/usuario");
		return mv;
	}
	
	@GetMapping("usuario/login")
	public ModelAndView login() {
	ModelAndView mv= new ModelAndView();
	mv.setViewName("usuario/login");
	return mv;
	}
	
	@GetMapping("")
	public ModelAndView admin() {
	ModelAndView mv= new ModelAndView();
	mv.setViewName("usuario/admin");
	return mv;
	}
	
	@GetMapping("cadastro")
	public ModelAndView cadastro(Usuario usuario) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/cadastro");
		mv.addObject("User", usuario);
		return mv;
	}
	
	@PostMapping("/processoCadastro")
	public ModelAndView processoCadastro(Usuario usuario) {
		ModelAndView mv = new ModelAndView();

		BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
		
		String encodePassword;
		
		encodePassword = passwordEncoder.encode(usuario.getPassword());
		
		usuario.setPassword(encodePassword);
		
		userRepositorio.save(usuario);

		mv.setViewName("redirect:/usuario/registro");

		return mv;
	}
	
	@GetMapping("/usuario/registro")
	public ModelAndView usuarioRegistrado() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/registro");
		return mv;
	}
	
	@GetMapping("/users")
	public String listUsers() {
		//ModelAndView mv =  new ModelAndView();
		List<Usuario> listUsers = userRepositorio.findAll();
	     
	    return "usuario/usuario";
	}
	
	

	
}

