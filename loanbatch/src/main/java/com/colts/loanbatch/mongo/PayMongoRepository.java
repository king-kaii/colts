package com.colts.loanbatch.mongo;

import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayMongoRepository extends MongoRepository<PaymentsMongo, String>{

	public List<PaymentsMongo> findByLoanId(int loanId);
	public PaymentsMongo save(PaymentsMongo payments);
	
	
}