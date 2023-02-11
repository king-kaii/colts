package com.colts.loanbatch.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsMongoController {
	@Autowired
	PayMongoRepository payMongoRepository;
	
	@GetMapping("/LbMo")
	public String getDetails() {
		return  "Hello LHMongo";
	}
	
	  @RequestMapping(value = "/readmongo", method = RequestMethod.GET)
	  public List<PaymentsMongo> readCustomer() {
	    return payMongoRepository.findAll();
	  }

}
