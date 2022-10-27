package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.BitCoin;
import com.demo.model.BitCoinObj;
import com.demo.model.DateRange;
import com.demo.service.BTCService;

@RestController
public class BitCoinController {

	@Autowired
	private BTCService btcService;

	
	@PostMapping("/loadBTC")
	@ResponseStatus(HttpStatus.CREATED)
	public void loadBTC(@RequestBody BitCoin bitCoin) {
		btcService.updateBTC(bitCoin);
	}
	
	@PostMapping("/getBTCHistory")
	public List<BitCoinObj> getBTCHistory(@RequestBody BitCoin range){
		return btcService.getBTCHistoryForDates(range);
	}
	
	@GetMapping("/getAllBTC")
	public List<BitCoinObj> getAllBTCEntries(){
		return btcService.getAllBTCEntries();
	}
	
	@GetMapping("/getBTCHistory/{amount}")
	public List<BitCoinObj> getBTCBasedOnAmount(@PathVariable("amount")int amount){
		return btcService.getBTCBasedOnAmount(amount);
	}
}
