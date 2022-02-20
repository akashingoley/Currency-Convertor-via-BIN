package com.ccApp.CurrencyConverter.controller;

import com.ccApp.CurrencyConverter.model.BinLookup;
import com.ccApp.CurrencyConverter.model.CurrencyConverter;
import com.ccApp.CurrencyConverter.service.BinService;
import com.ccApp.CurrencyConverter.service.ConvertorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {
    
    @Autowired
    private ConvertorService convertorService;
    @Autowired
    private BinService binService;

    @Value("${api.key}")
    private String apiKey;

    // Home

    @GetMapping("/")
    public String mainHome(){
        return "home";
    }

    // Convertor Controller

    @GetMapping("/convertor")
    public String convertorHome(){
        return "convertor";
    }

    @PostMapping("/convertor")
    public String convertorSaveData(CurrencyConverter currencyConverter, Model model){


        currencyConverter.exchange(apiKey);
        convertorService.saveData(currencyConverter);
        
        String from = currencyConverter.getFrom_amount() + " " +currencyConverter.getFrom_code();
        String to = currencyConverter.getConverted_amount() + " " +currencyConverter.getTo_code();

        String message = "The card is from "+ currencyConverter.getCountry() + " and the currency is "+ currencyConverter.getTo_code();
        model.addAttribute("from_amount", from);
        model.addAttribute("to_amount", to);
        model.addAttribute("message", message);

        return "convertor";
    }

    @GetMapping("/convertor/database")
    public String convertorDataBase(Model model){
        model.addAttribute("convertorData", convertorService.getAllData());
        return "convertorDatabase";
    }

    @GetMapping("convertor/delete/{id}")
    public String convertorDelete(@PathVariable(name = "id") Long id){
        convertorService.deleteData(id);
        return "redirect:/convertor/database";
    }

    // Bin LookUp Controller

    @GetMapping("/binlookup")
    public String binHome(){
        return "binlookup";
    }

    @PostMapping("/binlookup")
    public String binSaveData(BinLookup binLookup, Model model){
        binLookup.findInfo(binLookup.getCard_number());
        binService.saveData(binLookup);

        model.addAttribute("card_number", binLookup.getCard_number());
        model.addAttribute("country", binLookup.getCountry());
        model.addAttribute("scheme", binLookup.getScheme());
        model.addAttribute("currency", binLookup.getCurrency());
        model.addAttribute("brand", binLookup.getBrand());
        model.addAttribute("type", binLookup.getType());

        return "binlookup";
    }

    @GetMapping("/binlookup/database")
    public String binDatabase(BinLookup binLookup, Model model){
        model.addAttribute("binData", binService.getAllData());
        return "binDatabase";
    }

    @GetMapping("/binlookup/delete/{id}")
    public String binDelete(@PathVariable(name = "id") Long id ){
        binService.deleteData(id);
        return "redirect:/binlookup/database";
    }

}