package com.example.test.data.model;


import com.google.gson.annotations.SerializedName;

public class CardDto {

    @SerializedName("scheme")
    private String scheme;
    @SerializedName("type")
    private String type;
    @SerializedName("brand")
    private String brand;
    @SerializedName("prepaid")
    private boolean prepaid;
    @SerializedName("bank")
    private BankDto bank;
    @SerializedName("country")
    private CountryDto country;
    @SerializedName("number")
    private NumberDto number;

    public CardDto(String scheme, String type, String brand, boolean prepaid, BankDto bank, CountryDto country, NumberDto number) {
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

    public BankDto getBank() {
        return bank;
    }

    public CountryDto getCountry() {
        return country;
    }

    public NumberDto getNumber() {
        return number;
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
