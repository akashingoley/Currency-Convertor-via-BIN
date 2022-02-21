package com.ccApp.CurrencyConverter.repository;

import com.ccApp.CurrencyConverter.model.CurrencyConvertor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvertorRepo extends JpaRepository<CurrencyConvertor, Long> {
     
}
