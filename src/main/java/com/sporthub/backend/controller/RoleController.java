package com.sporthub.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sporthub.backend.model.Role;
import com.sporthub.backend.repository.RoleRepository;

@Controller
//Usare il CrossOrigin
//Backend e frontend sono su due porte diverse
//DA USARE SOLAMENTE QUANDO L'APPLICAZIONE GIRA IN LOCALE
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleRepository roleRepo;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Role> getRoles(){
		return roleRepo.findAll();
	}
	
	@PostMapping("/add")
	public @ResponseBody String addRole(
			@RequestParam String role_name
	) {
		
		Role role = new Role();
		role.setRole_name(role_name);
		roleRepo.save(role);
		return "added new role";
	}
}
