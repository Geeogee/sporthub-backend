package com.sporthub.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sporthub.backend.model.Playground;
import com.sporthub.backend.model.User;
import com.sporthub.backend.model.Voucher;
import com.sporthub.backend.repository.PlaygroundRepository;
import com.sporthub.backend.repository.UserRepository;

@Controller
//Usare il CrossOrigin
//Backend e frontend sono su due porte diverse
//DA USARE SOLAMENTE QUANDO L'APPLICAZIONE GIRA IN LOCALE
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/playground")
public class PlaygroundController {
	@Autowired
	private PlaygroundRepository playgroundRepo;
	

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Playground> getPlayground(){
		return playgroundRepo.findAll();
	}
	
	@PostMapping("/add")
	public @ResponseBody String addPlayground(
			@RequestParam Integer user_id,
			@RequestParam String sport_type,
			@RequestParam Integer tot_players,
			@RequestParam Boolean indoor,
			@RequestParam String address,
			@RequestParam String city,
			@RequestParam Boolean availability,
			@RequestParam Double price_hour
	) {
		Optional<User> user = userRepo.findById(user_id);
		if(user.isPresent()) {
			Playground playground = new Playground();
			playground.setSport_type(sport_type);
			playground.setTot_players(tot_players);
			playground.setPrice_hour(price_hour);
			playground.setIndoor(indoor);
			playground.setAddress(address);
			playground.setCity(city);
			playground.setAvailability(availability);
			playground.setUser(user.get());
			playgroundRepo.save(playground);
			return "added new playground";
		}
		return "unable to add playground";
	}
}
