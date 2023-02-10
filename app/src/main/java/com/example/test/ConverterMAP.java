package com.example.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConverterMAP {
    private final FilterCard filterCard = new FilterCard();


    private final Map<String, String> myLinkedHashMap = new LinkedHashMap<>();

    public Map<String, String> convert(Card card) {

        myLinkedHashMap.put("Scheme:", card.getScheme());
        myLinkedHashMap.put("Type:", card.getType());
        myLinkedHashMap.put("Brand:", card.getBrand());
        myLinkedHashMap.put("Prepaid:", booleanToString(card.isPrepaid(), "Yes", "No"));
        myLinkedHashMap.put("Bank:", bankInfo(card));
        myLinkedHashMap.put("Bank phone:", card.getBank().getPhone());
        myLinkedHashMap.put("Bank URL:", card.getBank().getUrl());
        myLinkedHashMap.put("Country:", countryInfo(card.getCountry()));
        myLinkedHashMap.put("Number:", numberInfo(card.getNumber()));
        return filterCard.filterMap(myLinkedHashMap);
    }

    private String countryInfo(Country country) {
        String cardCountryInfo = null;
        if(country != null) {
            if (country.getAlpha2() != null && country.getName() != null) {
                cardCountryInfo = country.getAlpha2() + " " + country.getName();
            } else if (country.getName() != null) {
                cardCountryInfo = country.getName();
            } else if (country.getAlpha2() != null) {
                cardCountryInfo = country.getAlpha2();
            }
        }
        return cardCountryInfo;
    }

    private String bankInfo(Card card) {
        String cardBankNameCity = "";
        if (card.getBank().getName() != null && card.getBank().getCity() != null) {
            cardBankNameCity = card.getBank().getName() + ", " + card.getBank().getCity();
        } else if (card.getBank().getCity() != null) {
            cardBankNameCity = card.getBank().getCity();
        } else if (card.getBank().getName() != null) {
            cardBankNameCity = card.getBank().getName();
        }
        return cardBankNameCity;
    }

    private String numberInfo(Number number) {
        String numberCardInfo = "";
        if (number.getLength() != null && number.isLuhn() != null) {
            numberCardInfo = "Length: " + number.getLength() + "\n" + "Luhn: " + booleanToString(number.isLuhn(), "Yes", "No");
        } else if (number.getLength() != null) {
            numberCardInfo = "Length: " + number.getLength();
        } else if (number.isLuhn() != null) {
            numberCardInfo = "Luhn: " + booleanToString(number.isLuhn(), "Yes", "No");
        }
        return numberCardInfo;
    }

    private String booleanToString(Boolean predicate, String trueString, String falseString) {
        String result = null;
        if (predicate != null) {
            if (predicate) {
                result = trueString;
            }
            else {
                result = falseString;
            }
        }
        return result;
    }

}

