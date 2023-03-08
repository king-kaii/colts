package com.colt.lbconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colt.lbconnect.entities.Lender;
import com.colt.lbconnect.repository.LenderRepository;


@Service
public class LenderService {

	@Autowired
	LenderRepository lenderRepository;
	
	public Iterable<Lender> getLenders() {
		// TODO Auto-generated method stub
		return lenderRepository.findAll();
		
	}

	public Lender saveLender(Lender lender) {
		return lenderRepository.save(lender);
		
	}

	

}
