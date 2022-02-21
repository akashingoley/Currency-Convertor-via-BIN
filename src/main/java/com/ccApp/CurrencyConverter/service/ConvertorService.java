package com.ccApp.CurrencyConverter.service;

import java.util.List;

import com.ccApp.CurrencyConverter.model.CurrencyConvertor;

public interface ConvertorService {
    
    List<CurrencyConvertor> getAllData();
    void saveData(CurrencyConvertor currencyConverter);
    void deleteData(Long id);
}
