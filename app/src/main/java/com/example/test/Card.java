package com.example.test;

import com.google.gson.annotations.SerializedName;

public class Card {

    @SerializedName("scheme")
    private String scheme;
    @SerializedName("type")
    private String type;
    @SerializedName("brand")
    private String brand;
    @SerializedName("prepaid")
    private boolean prepaid;
    @SerializedName("bank")
    private Bank bank;
    @SerializedName("country")
    private Country country;
    @SerializedName("number")
    private Number number;

    public Card(String scheme, String type, String brand, boolean prepaid, Bank bank, Country country, Number number) {
        this.scheme = scheme;
        this.type = type;
        this.brand = brand;
        this.prepaid = prepaid;
        this.bank = bank;
        this.country = country;
        this.number = number;
    }

    public String getScheme() {
        return scheme;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isPrepaid() {
        return prepaid;
    }

    public Bank getBank() {
        return bank;
    }

    public Country getCountry() {
        return country;
    }

    public Number getNumber() {
        return number;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "Card{" +
                "scheme='" + scheme + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", prepaid=" + prepaid +
                ", bank=" + bank +
                ", country=" + country +
                ", number=" + number +
                '}';
    }
}
