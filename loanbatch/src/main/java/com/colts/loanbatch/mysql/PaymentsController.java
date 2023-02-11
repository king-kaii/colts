package com.colts.loanbatch.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {
	@Autowired
	PaymentsRepository paymentsRepository;
	
	@GetMapping("/lbmy")
	public String getDetails() {
		return  "Hello LbMysql";
	}
	
	  @RequestMapping(value = "/readmysql", method = RequestMethod.GET)
	  public Iterable<Payments> readCustomer() {
	    return paymentsRepository.findAll();
	  }

}
