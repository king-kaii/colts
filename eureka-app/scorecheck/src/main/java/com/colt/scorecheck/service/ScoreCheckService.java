package com.colt.scorecheck.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ScoreCheckService {

	public int checkScore(int borrowerId) {
		Random randomObj = new Random();
		int randomNum = randomObj.nextInt((800 - 700)) + 700;
		return randomNum;
	}

}
