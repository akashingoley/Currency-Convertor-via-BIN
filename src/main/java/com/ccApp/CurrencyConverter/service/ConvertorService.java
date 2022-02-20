package com.ccApp.CurrencyConverter.service;

import java.util.List;

import com.ccApp.CurrencyConverter.model.CurrencyConverter;

public interface ConvertorService {
    
    List<CurrencyConverter> getAllData();
    void saveData(CurrencyConverter currencyConverter);
    void deleteData(Long id);
}
