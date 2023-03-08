package com.colt.lbconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.colt.lbconnect.entities.Lender;
import com.colt.lbconnect.service.LenderService;

@RestController
public class LenderController {
	
	@Autowired
	LenderService lenderService;
	
	@GetMapping("/hi")
	public String greeting() {
		return "Hello";
	}

	@GetMapping("/getAll")
	public Iterable<Lender> getAll() {
		return lenderService.getLenders();
	}

	@PostMapping("/saveLender")
	public Lender saveLender(@RequestBody Lender lender) {
		
		return lenderService.saveLender(lender);
		
		
	}
	
	
	
}
