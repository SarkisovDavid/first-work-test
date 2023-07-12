package com.example.test.data.model;

import com.google.gson.annotations.SerializedName;

public class BankDto {

    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("phone")
    private String phone;
    @SerializedName("city")
    private String city;

    public BankDto(String name, String url, String phone, String city) {
        this.name = name;
        this.url = url;
        this.phone = phone;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
