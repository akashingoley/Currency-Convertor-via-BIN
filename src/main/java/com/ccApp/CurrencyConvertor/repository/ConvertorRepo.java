package com.ccApp.CurrencyConvertor.repository;

import com.ccApp.CurrencyConvertor.model.CurrencyConvertor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvertorRepo extends JpaRepository<CurrencyConvertor, Long> {
     
}
