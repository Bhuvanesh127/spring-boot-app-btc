package com.demo.service;

import java.util.List;

import com.demo.model.BitCoin;
import com.demo.model.BitCoinObj;
import com.demo.model.DateRange;

public interface BTCService {

	public void updateBTC(BitCoin bitcoin);
	
	public List<BitCoinObj> getBTCHistoryForDates(BitCoin dateRange);

	public List<BitCoinObj> getAllBTCEntries();
	
	public List<BitCoinObj> getBTCBasedOnAmount(int amount);
}
