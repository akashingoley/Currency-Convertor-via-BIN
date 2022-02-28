package com.ccApp.CurrencyConvertor.service;

import java.util.List;

import com.ccApp.CurrencyConvertor.model.CurrencyConvertor;
import com.ccApp.CurrencyConvertor.repository.ConvertorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ConvertorServiceImpl implements ConvertorService {

    @Autowired
    private ConvertorRepo convertorRepo;

    @Override
    public List<CurrencyConvertor> getAllData() {
        return convertorRepo.findAll();
    }

    @Override
    public void saveData(CurrencyConvertor currencyConverter) {
        this.convertorRepo.save(currencyConverter);
    }

    @Override
    public void deleteData(Long id) {
        this.convertorRepo.deleteById(id);
    }

}
