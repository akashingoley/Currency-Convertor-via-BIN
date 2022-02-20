package com.ccApp.CurrencyConverter.repository;

import com.ccApp.CurrencyConverter.model.BinLookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinRepo extends JpaRepository<BinLookup, Long> {
    
}
