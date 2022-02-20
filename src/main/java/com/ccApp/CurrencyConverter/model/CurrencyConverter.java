package com.ccApp.CurrencyConverter.model;

import org.springframework.web.client.RestTemplate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;

@Entity
@Table(name = "Conversion")
public class CurrencyConverter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Date")
    private Date date;
    @Column(name = "Card_number")
    private long card_number;
    @Column(name = "From_Currency")
    private String from_code;
    @Column(name = "To_Currency")
    private String to_code;
    @Column(name = "Amount")
    private double from_amount;
    @Column(name = "Converted_Amount")
    private double converted_amount;
    @Column(name = "Exchange_Rate")
    private double exchange_rate;
    
    public CurrencyConverter() {
    }

    
    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom_code() {
        return from_code;
    }

    public void setFrom_code(String from_code) {
        this.from_code = from_code;
    }

    public String getTo_code() {
        return to_code;
    }

    public void setTo_code(String to_code) {
        this.to_code = to_code;
    }

    public double getFrom_amount() {
        return from_amount;
    }

    public void setFrom_amount(double from_amount) {
        this.from_amount = from_amount;
    }

    public double getConverted_amount() {
        return converted_amount;
    }

    public void setConverted_amount(double converted_amount) {
        this.converted_amount = converted_amount;
    }

    public double getExchange_rate() {
        return exchange_rate;
    }

    public void setExchange_rate(double exchange_rate) {
        this.exchange_rate = exchange_rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getCard_number() {
        return card_number;
    }

    public void setCard_number(long card_number) {
        this.card_number = card_number;
    }

    private String country;
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public void exchange(String apiKey) {

        // Fecthing date
        long millis = System.currentTimeMillis();
        this.date = new Date(millis);

        // For consuming api services 
        RestTemplate restTemplate = new RestTemplate();

        // Fetching country currency from card number
        BinLookup binLookup = new BinLookup();

        binLookup.findInfo(card_number);

        to_code = binLookup.getCurrency();
        country = binLookup.getCountry();

        // Fetching exchange rate 
        String ex_rate_url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + from_code + "/" + to_code;
        
        Exchange conversion_rate = restTemplate.getForObject(ex_rate_url, Exchange.class);

        // Current conversion rate
        this.exchange_rate = conversion_rate.getConversion_rate();

        // Doing the conversion
        convert();
        return;
    }

    public void convert() {
        // For rounding off upto 2 decimal
        DecimalFormat df = new DecimalFormat("###.###");
        df.setRoundingMode(RoundingMode.DOWN);
        if (from_amount != 0) {
            this.converted_amount = Double.parseDouble(df.format(from_amount * exchange_rate));
        } else {
            this.converted_amount = 0;
        }
    }
}
// cd09efb1e6c75e27bb87db0c