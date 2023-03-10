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
        myHashMap.put("Prepaid:", prepaidInfo(card));
        myHashMap.put("Bank:", bankInfo(card.getBank()));
        myHashMap.put("Country:", countryInfo(card));
        myHashMap.put("Number:", numberInfo(card.getNumber()));
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

    private String bankInfo(Bank bank) {
        return bank.getName() + ", " + bank.getCity() + "\n" + bank.getPhone() + "\n" + bank.getUrl();
    }

    private String numberInfo(Number number) {
        return "Length: " + number.getLength() + "\n" + "Luhn: " + booleanToString(number.isLuhn(), "Yes", "No");
    }

    private String prepaidInfo(Card card) {
        return booleanToString(card.isPrepaid(), "Yes", "No");
    }

    private String booleanToString(Boolean predicate, String trueString, String falseString) {
        String result;
        if (predicate) {
            result = trueString;
        } else {
            result = falseString;
        }
        return result;
    }

}

