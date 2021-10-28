package com.sporthub.backend.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sporthub.backend.model.Playground;
import com.sporthub.backend.model.Voucher;
import com.sporthub.backend.repository.PlaygroundRepository;
import com.sporthub.backend.repository.VoucherRepository;

@Controller
//Usare il CrossOrigin
//Backend e frontend sono su due porte diverse
//DA USARE SOLAMENTE QUANDO L'APPLICAZIONE GIRA IN LOCALE
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/voucher")
public class VoucherController {
	@Autowired
	private VoucherRepository voucherRepo;
	
	@Autowired
	private PlaygroundRepository playgroundRepo;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Voucher> getVouchers(){
		return voucherRepo.findAll();
	}
	
	@PostMapping("/add")
	public @ResponseBody Voucher addVoucher(
			@RequestParam Integer rentals_left,
			@RequestParam @DateTimeFormat(pattern="dd/MM/yyyy") LocalDate start_date,
			@RequestParam @DateTimeFormat(pattern="dd/MM/yyyy") LocalDate end_date,
			@RequestParam Integer playground_id
	) {
		Optional<Playground> pg = playgroundRepo.findById(playground_id);
		System.out.println("start_date --> "+ start_date);
		System.out.println("end_date --> "+ end_date);
		if(pg.isPresent()) {
			Voucher voucher = new Voucher();
			voucher.setRentals_left(rentals_left);
			voucher.setStartDate(start_date);
			voucher.setEnd_date(end_date);
			voucher.setPlayground(pg.get());
			voucherRepo.save(voucher);
			return voucher;
		}
		return null;
	}
}
