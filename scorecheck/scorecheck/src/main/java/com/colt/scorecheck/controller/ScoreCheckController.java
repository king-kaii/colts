package com.colt.scorecheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colt.scorecheck.service.ScoreCheckService;



@RestController
@RequestMapping("/scorecheck")
public class ScoreCheckController {
	
	@Autowired
	ScoreCheckService scoreCheckService;
	
	@GetMapping("/score/{borrowerId}")
	public int scoreCheck(@PathVariable int borrowerId){
		return scoreCheckService.checkScore(borrowerId);
	}

}
