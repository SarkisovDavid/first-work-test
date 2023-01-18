package com.example.test;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("numeric")
    private int numeric;
    @SerializedName("alpha2")
    private String alpha2;
    @SerializedName("name")
    private String name;
    @SerializedName("emoji")
    private String emoji;
    @SerializedName("currency")
    private String currency;
    @SerializedName("latitude")
    private int latitude;
    @SerializedName("longitude")
    private int longitude;

    public Country(int numeric, String alpha2, String name, String emoji, String currency, int latitude, int longitude) {
        this.numeric = numeric;
        this.alpha2 = alpha2;
        this.name = name;
        this.emoji = emoji;
        this.currency = currency;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getNumeric() {
        return numeric;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public String getName() {
        return name;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getCurrency() {
        return currency;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }
}
