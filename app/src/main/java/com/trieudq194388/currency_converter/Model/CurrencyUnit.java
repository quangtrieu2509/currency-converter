package com.trieudq194388.currency_converter.Model;

public class CurrencyUnit {
    private String code;
    private String countryName;
    private String currencyName;
    private String symbol;
    private double rate;

    public CurrencyUnit() {
    }

    public CurrencyUnit(String code, String countryName, String currencyName, String symbol, double rate) {
        this.code = code;
        this.countryName = countryName;
        this.currencyName = currencyName;
        this.symbol = symbol;
        this.rate = rate;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
