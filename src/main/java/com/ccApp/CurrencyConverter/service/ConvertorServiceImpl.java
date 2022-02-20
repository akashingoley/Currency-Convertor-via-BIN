package com.ccApp.CurrencyConverter.service;

import java.util.List;

import com.ccApp.CurrencyConverter.model.CurrencyConverter;
import com.ccApp.CurrencyConverter.repository.ConvertorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ConvertorServiceImpl implements ConvertorService {

    @Autowired
    private ConvertorRepo convertorRepo;

    @Override
    public List<CurrencyConverter> getAllData() {
        return convertorRepo.findAll();
    }

    @Override
    public void saveData(CurrencyConverter currencyConverter) {
        this.convertorRepo.save(currencyConverter);
    }

    @Override
    public void deleteData(Long id) {
        this.convertorRepo.deleteById(id);
    }

}
