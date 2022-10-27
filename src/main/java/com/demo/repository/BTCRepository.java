package com.demo.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.model.BitCoin;
import com.demo.model.BitCoinObj;

public interface BTCRepository extends JpaRepository<BitCoinObj, Long>{

	@Query("SELECT b from BitCoinObj b where b.receivedAt >= :startDate and b.receivedAt <= :endDate order by receivedAt")
	public List<BitCoinObj> getBTCHistory(@Param("startDate")Date from, 
			@Param("endDate")Date to);
	
	@Query("SELECT a from BitCoinObj a where a.amount >= :amount")
	public List<BitCoinObj> getBTCAmountFilter(@Param("amount")double amount);
}
