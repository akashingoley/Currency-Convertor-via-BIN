package com.ccApp.CurrencyConverter.repository;

import com.ccApp.CurrencyConverter.model.CurrencyConverter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvertorRepo extends JpaRepository<CurrencyConverter, Long> {
     
}
