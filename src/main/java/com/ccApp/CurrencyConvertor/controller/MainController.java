package com.ccApp.CurrencyConvertor.controller;

import com.ccApp.CurrencyConvertor.model.BinLookup;
import com.ccApp.CurrencyConvertor.model.CurrencyConvertor;
import com.ccApp.CurrencyConvertor.service.BinService;
import com.ccApp.CurrencyConvertor.service.ConvertorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpStatusCodeException;

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
    public String mainHome() {
        return "home";
    }

    // Convertor Controller

    @GetMapping("/convertor")
    public String convertorHome() {
        return "convertor";
    }

    // When card number is inserted
    @PostMapping(value = "/convertor", params = "card")
    public String convertorSaveDataCard(CurrencyConvertor currencyConvertor, Model model) {

        try {
            currencyConvertor.exchange(apiKey);
            convertorService.saveData(currencyConvertor);

            String from = currencyConvertor.getFrom_amount() + " " + currencyConvertor.getFrom_code();
            String to = currencyConvertor.getConverted_amount() + " " + currencyConvertor.getTo_code();

            String message = "The card is from " + currencyConvertor.getCountry() + " and the currency is "
                    + currencyConvertor.getTo_code();
            model.addAttribute("from_amount", from);
            model.addAttribute("to_amount", to);
            model.addAttribute("message", message);
        } catch (HttpStatusCodeException ex) {
            String error_message = "The card details are wrong";
            model.addAttribute("error_message", error_message);
        }

        return "convertor";
    }

    // When to_code is given
    @PostMapping(value = "/convertor", params = "currency")
    public String convertorSaveDataCurr(CurrencyConvertor currencyConvertor, Model model) {

        try {
            currencyConvertor.exchange(apiKey);
            convertorService.saveData(currencyConvertor);

            String from = currencyConvertor.getFrom_amount() + " " + currencyConvertor.getFrom_code();
            String to = currencyConvertor.getConverted_amount() + " " + currencyConvertor.getTo_code();

            String message = "The card is from " + currencyConvertor.getCountry() + " and the currency is "
                    + currencyConvertor.getTo_code();
            model.addAttribute("from_amount", from);
            model.addAttribute("to_amount", to);
            model.addAttribute("message", message);
        } catch (HttpStatusCodeException ex) {
            String error_message = "The card details are wrong";
            model.addAttribute("error_message", error_message);
        }

        return "convertor";
    }

    @GetMapping("/convertor/database")
    public String convertorDataBase(Model model) {
        model.addAttribute("convertorData", convertorService.getAllData());
        return "convertorDatabase";
    }

    @GetMapping("convertor/delete/{id}")
    public String convertorDelete(@PathVariable(name = "id") Long id) {
        convertorService.deleteData(id);
        return "redirect:/convertor/database";
    }

    // Bin LookUp Controller

    @GetMapping("/binlookup")
    public String binHome() {
        return "binlookup";
    }

    @PostMapping("/binlookup")
    public String binSaveData(BinLookup binLookup, Model model) {
        try {
            binLookup.findInfo(binLookup.getCard_number());
            binService.saveData(binLookup);

            model.addAttribute("card_number", binLookup.getCard_number());
            model.addAttribute("country", binLookup.getCountry());
            model.addAttribute("scheme", binLookup.getScheme());
            model.addAttribute("currency", binLookup.getCurrency());
            model.addAttribute("brand", binLookup.getBrand());
            model.addAttribute("type", binLookup.getType());
        } catch (HttpStatusCodeException ex) {
            String error_message = "The card details are wrong";
            model.addAttribute("error_message", error_message);
        }

        return "binlookup";
    }

    @GetMapping("/binlookup/database")
    public String binDatabase(BinLookup binLookup, Model model) {
        model.addAttribute("binData", binService.getAllData());
        return "binDatabase";
    }

    @GetMapping("/binlookup/delete/{id}")
    public String binDelete(@PathVariable(name = "id") Long id) {
        binService.deleteData(id);
        return "redirect:/binlookup/database";
    }

}