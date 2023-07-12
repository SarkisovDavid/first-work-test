package com.example.test.domain.model;


public class MainCardInfo implements CardInfoItemModel {

    public String key;
    public String value;

    public MainCardInfo(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String header() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
