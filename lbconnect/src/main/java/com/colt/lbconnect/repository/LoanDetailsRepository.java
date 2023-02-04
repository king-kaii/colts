package com.colt.lbconnect.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colt.lbconnect.entities.LoanDetails;

@Repository
public interface LoanDetailsRepository extends CrudRepository<LoanDetails, Integer> {

}