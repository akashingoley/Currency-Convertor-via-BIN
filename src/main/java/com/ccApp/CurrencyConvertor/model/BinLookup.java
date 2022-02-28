package com.ccApp.CurrencyConvertor.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.client.RestTemplate;

@Entity
@Table(name = "Binlookup")
public class BinLookup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Date")
    private Date date;
    @Column(name = "Card_number")
    private long card_number;
    @Column(name = "Country")
    private String country;
    @Column(name= "Currency")
    private String currency;
    @Column(name = "Scheme")
    private String scheme;
    @Column(name = "type")
    private String type;
    @Column(name = "Brand")
    private String brand;

    public BinLookup(){
    }

    // Getters and Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getScheme() {
        return scheme;
    }
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void findInfo(long card_number){
        // Fecthing date
        long millis = System.currentTimeMillis();
        this.date = new Date(millis);

        // For consuming api services 
        RestTemplate restTemplate = new RestTemplate();

        // Fetching country currency from card number
        String bin_url = "https://lookup.binlist.net/"+card_number;
        CardDetails details = restTemplate.getForObject(bin_url, CardDetails.class);

        this.currency = details.getCountry().getCurrency();
        this.country = details.getCountry().getName();
        this.scheme = details.getScheme();
        this.type = details.getType();
        this.brand = details.getBrand();
    }


    
}
