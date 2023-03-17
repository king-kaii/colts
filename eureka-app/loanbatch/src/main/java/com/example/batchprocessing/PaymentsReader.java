package com.example.batchprocessing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.colts.loanbatch.mysql.Payments;
import com.colts.loanbatch.mysql.PaymentsRepository;

public class PaymentsReader implements ItemReader<Payments> {

	
	@Autowired
	PaymentsRepository paymentsRepository;
	
	@Override
	public Payments read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		List<Payments> paymentList = new ArrayList<>();
		paymentList= (List<Payments>) paymentsRepository.findAll();
		Payments p = new Payments();
		p=paymentList.stream().findFirst().get();
		paymentList.remove(paymentList.stream().findFirst().get());
		return p;
	}

}
