package com.ccApp.CurrencyConverter.service;

import java.util.List;

import com.ccApp.CurrencyConverter.model.BinLookup;
import com.ccApp.CurrencyConverter.repository.BinRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BinServiceImpl implements BinService {

    @Autowired
    private BinRepo binRepo;

    @Override
    public List<BinLookup> getAllData() {
        return binRepo.findAll();
    }

    @Override
    public void saveData(BinLookup binLookup) {
        this.binRepo.save(binLookup);
    }

    @Override
    public void deleteData(Long id) {
        this.binRepo.deleteById(id);
    }
    
}
