package com.example.batchprocessing;

import java.time.LocalDate;

import org.springframework.batch.item.ItemProcessor;

import com.colts.loanbatch.mongo.PaymentsMongo;
import com.colts.loanbatch.mysql.Payments;

public class ValidationProcessor implements ItemProcessor<Payments, PaymentsMongo> {

	@Override
	public PaymentsMongo process(Payments p) throws Exception {
       	 PaymentsMongo pm = new PaymentsMongo(p.getPaymentId(), p.getLoanId(),LocalDate.now(), p.getUTR(), p.getAmount());
           return pm;
	}

}
