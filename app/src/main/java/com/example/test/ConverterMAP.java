package com.example.test;

import java.util.HashMap;
import java.util.Map;

public class ConverterMAP {

    private final Map<String, String> myHashMap = new HashMap<>();

    public Map<String, String> convert(Card card) {

        if(card.getScheme() != null && !card.getScheme().isEmpty()) {
        myHashMap.put("scheme", card.getScheme());}
        myHashMap.put("type", card.getType());
        myHashMap.put("brand", card.getBrand());
        myHashMap.put("prepaid", Boolean.toString(card.isPrepaid()));
        myHashMap.put("bank", card.getBank().toString());
        myHashMap.put("country", countryInfo(card));
        myHashMap.put("number", card.getNumber().toString());
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
