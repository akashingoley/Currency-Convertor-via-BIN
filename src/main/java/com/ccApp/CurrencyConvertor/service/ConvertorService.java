package com.ccApp.CurrencyConvertor.service;

import java.util.List;

import com.ccApp.CurrencyConvertor.model.CurrencyConvertor;

public interface ConvertorService {
    
    List<CurrencyConvertor> getAllData();
    void saveData(CurrencyConvertor currencyConvertor);
    void deleteData(Long id);
}
