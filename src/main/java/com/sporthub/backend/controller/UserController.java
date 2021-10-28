package com.sporthub.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sporthub.backend.model.Role;
import com.sporthub.backend.model.User;
import com.sporthub.backend.repository.RoleRepository;
import com.sporthub.backend.repository.UserRepository;

@Controller
// Usare il CrossOrigin
// Backend e frontend sono su due porte diverse
// DA USARE SOLAMENTE QUANDO L'APPLICAZIONE GIRA IN LOCALE
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<User> getUsers(){
		return userRepo.findAll();
	}
	
	@PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User addUser(
			@RequestBody User user
	) {
//		Optional<Role> role = roleRepo.findById(role_id);
//		if(role.isPresent()) {
//			User user = new User();
//			user.setFirst_name(first_name);
//			user.setLast_name(last_name);
//			user.setEmail(email);
//			user.setPassword(password);
//			user.setPhone_number(phone_number);
//			user.setCity(city);
//			user.setAddress(address);
//			user.setZip_code(zip_code);
//			user.setDocument_id(document_id);
//			user.setRole(role.get());
//			userRepo.save(user);
		
			System.out.println(user.toString());
			userRepo.save(user);
			return user;
	}
	
	@PostMapping(path="/delete",  produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void deleteUser(@RequestBody User user) {
		
		int user_id = user.getUser_id();
		Optional<User> optUser = userRepo.findById(user_id);
		if(optUser.isPresent()) {
			
			userRepo.delete(user);
			System.out.println("Utente cancellato!");
		}
		
		System.out.println("Utente non presente nel database!");
	}
	
	@PostMapping(path="/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User updateUser(@RequestBody User user) {
		
		int user_id = user.getUser_id();
		Optional<User> userToUpdate = userRepo.findById(user_id);
		
		if(userToUpdate.isPresent()) {
			
			userRepo.save(user);
		}
		return user;
	}
}
