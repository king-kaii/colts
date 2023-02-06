package com.colt.lbconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.colt.lbconnect.service.PaymentService;

@RestController
@RequestMapping("/pay")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/EMI")
	public String payEMI(@RequestParam int id,@RequestParam long UTR,@RequestParam int amount) {
			return "Payment Success with Payment"+paymentService.pay(id,UTR,amount);
	}


	
	
}
