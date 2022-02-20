package com.ccApp.CurrencyConverter.service;

import java.util.List;

import com.ccApp.CurrencyConverter.model.BinLookup;

public interface BinService {
    
    List<BinLookup> getAllData();
    void saveData(BinLookup binLookup);
    void deleteData(Long id);
}
