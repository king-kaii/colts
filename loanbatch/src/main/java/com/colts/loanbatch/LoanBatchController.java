package com.colts.loanbatch;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colts.loanbatch.mongo.PayMongoRepository;
import com.colts.loanbatch.mongo.PaymentsMongo;
import com.colts.loanbatch.mysql.Payments;
import com.colts.loanbatch.mysql.PaymentsRepository;

@RestController
public class LoanBatchController {

	@Autowired 
	PayMongoRepository payMongoRepository;
	
	@Autowired 
	PaymentsRepository paymentsRepository;
	
	
	@GetMapping("/movedata")
	@Transactional
	@Scheduled(cron = "*/50 * * * * *")
	public void moveData() {
		List<Payments> paymentList = new ArrayList<>();
		List<PaymentsMongo> paymentMongoList = new ArrayList<>();
		paymentList= (List<Payments>) paymentsRepository.findAll();
		
		for(Payments p : paymentList) {
			PaymentsMongo pm = new PaymentsMongo(p.getPaymentId(), p.getLoanId(),LocalDate.now(), p.getUTR(), p.getAmount());
			paymentMongoList.add(pm);
		}
		
		payMongoRepository.saveAll(paymentMongoList);
		
	}
	
	
	
	public void sayHi() {
		System.out.println("I am running for every one minutes");
	}
}
