package com.ccApp.CurrencyConvertor.repository;

import com.ccApp.CurrencyConvertor.model.BinLookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinRepo extends JpaRepository<BinLookup, Long> {
    
}
