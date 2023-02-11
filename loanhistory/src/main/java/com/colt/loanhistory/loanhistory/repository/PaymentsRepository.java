package com.colt.loanhistory.loanhistory.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.colt.loanhistory.loanhistory.entities.Payments;

@Repository
public interface PaymentsRepository extends MongoRepository<Payments, String>{

	public List<Payments> findByLoanId(int loanId);
	public Payments save(Payments payments);
	
	
}
