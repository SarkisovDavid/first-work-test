package com.example.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapExsample {

    private final Map<String, String> myLinkedHashMap = new LinkedHashMap<>();

    public Map<String, String> convert(Card card) {
        myLinkedHashMap.put("Card Info", cardInfo(card));
        return myLinkedHashMap;
    }

    private String cardInfo (Card card) {
        String cardInfoResult = "";
        if (card.getScheme() != null){
            cardInfoResult = cardInfoResult + card.getScheme();
        }if (card.getNumber() != null){
            cardInfoResult = cardInfoResult + ", " + card.getNumber().toString();
        }
        return cardInfoResult;
    }

    }


