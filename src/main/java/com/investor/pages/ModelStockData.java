package com.investor.pages;


public class ModelStockData {
    String name, symbol, price, dailyChange;

    public ModelStockData(String name, String symbol, String price, String dailyChange) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.dailyChange = dailyChange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDailyChange() {
        return dailyChange;
    }

    public void setDailyChange(String dailyChange) {
        this.dailyChange = dailyChange;
    }
}
