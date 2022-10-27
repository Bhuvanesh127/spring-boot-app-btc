package com.demo.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.BitCoin;
import com.demo.model.BitCoinObj;
import com.demo.model.DateRange;
import com.demo.repository.BTCRepository;

@Service
public class BTCServiceImpl implements BTCService{

	@Autowired
	private BTCRepository repository;
	
	@Override
	public void updateBTC(BitCoin bitcoin) {
		Date date = convertToUTCFormat(bitcoin.getReceivedAt());
        BitCoinObj bit = new BitCoinObj(date, bitcoin.getAmount());
		repository.save(bit);
	}

	@Override
	public List<BitCoinObj> getBTCHistoryForDates(BitCoin dateRange) {
		System.out.println("From date: "+dateRange.getFromDate());
		System.out.println("To date  : "+dateRange.getToDate());
		Date fromDate = convertToUTCFormat(dateRange.getFromDate());
		Date toDate = convertToUTCFormat(dateRange.getToDate());
		
		List<BitCoinObj> bitCoins = repository.getBTCHistory(fromDate, toDate);
		System.out.println("Rows fetched from database: "+bitCoins.size());
		for (BitCoinObj bit : bitCoins) {
			System.out.println(bit.toString());
			Timestamp timestamp = (Timestamp) bit.getReceivedAt();
			
		}
		return bitCoins;
	}
	
	private Date convertToUTCFormat(String date) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssxxxxx");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZoneId destinationTimeZone = ZoneId.of("+00:00");
        ZonedDateTime givenTime = ZonedDateTime.parse(date, dateTimeFormatter); 
        ZonedDateTime givenTimeInUTC = givenTime.withZoneSameInstant(destinationTimeZone);
        
        System.out.printf("Given TIme::");
        System.out.println(outputFormatter.format(givenTime));
        System.out.printf("Time in UTC::");
        System.out.println(outputFormatter.format(givenTimeInUTC));
        
        //SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        //isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        //Date parsedDate = isoFormat.parse(date);
        Date convertedDate = Date.from(givenTimeInUTC.toInstant());
        System.out.println("UTC DateTime :"+ convertedDate);
        return convertedDate;
	}

	@Override
	public List<BitCoinObj> getAllBTCEntries() {
		List<BitCoinObj> entries = repository.findAll();
		System.out.println("Total entries - all : "+entries.size());
		return entries;
	}
	
	public List<BitCoinObj> getBTCBasedOnAmount(int amount){
		List<BitCoinObj> entries = repository.getBTCAmountFilter((double)amount);
		System.out.println("Total entries - amount : "+entries.size());
		return entries;
	}

}
