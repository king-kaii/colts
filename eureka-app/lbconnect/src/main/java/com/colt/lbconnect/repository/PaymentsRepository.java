package com.colt.lbconnect.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colt.lbconnect.entities.LoanDetails;
import com.colt.lbconnect.entities.Payments;

@Repository
public interface PaymentsRepository extends CrudRepository<Payments, Integer> 
{

}
