package com.colt.lbconnect.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colt.lbconnect.entities.Borrower;

@Repository
public interface BorrowerRepository extends CrudRepository<Borrower,Integer>{
	

}
