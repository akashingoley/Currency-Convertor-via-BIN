package com.ccApp.CurrencyConvertor.service;

import java.util.List;

import com.ccApp.CurrencyConvertor.model.BinLookup;

public interface BinService {
    
    List<BinLookup> getAllData();
    void saveData(BinLookup binLookup);
    void deleteData(Long id);
}
