package com.example.test;

import java.util.HashMap;
import java.util.Map;

public class ConverterMAP {

    private final Map<String, String> myHashMap = new HashMap<>();

    public Map<String, String> convert(Card card) {

        if(card.getScheme() != null && !card.getScheme().isEmpty()) {
        myHashMap.put("Scheme:", card.getScheme());}
        myHashMap.put("Type:", card.getType());
        myHashMap.put("Brand:", card.getBrand());
        myHashMap.put("Prepaid:", Boolean.toString(card.isPrepaid()));
        myHashMap.put("Bank:", card.getBank().toString());
        myHashMap.put("Country:", countryInfo(card));
        myHashMap.put("Number:", card.getNumber().toString());
        return myHashMap;
    }

    private String countryInfo(Card card) {
        String cardCountryInfo;
        if (card.getCountry().getAlpha2() != null && card.getCountry().getName() != null) {
            cardCountryInfo = card.getCountry().getAlpha2() + " " + card.getCountry().getName();
        } else if (card.getCountry().getAlpha2() == null && card.getCountry().getName() == null) {
            cardCountryInfo = card.getCountry().getName();
        } else if (card.getCountry().getAlpha2() != null) {
            cardCountryInfo = card.getCountry().getAlpha2();
        } else {
            cardCountryInfo = "";
        }
        return cardCountryInfo;
    }

}

