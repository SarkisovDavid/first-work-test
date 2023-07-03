package com.example.test;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

public class CardEntityConverter {

    private FilterCard filterCard;

    @Inject
    public CardEntityConverter(FilterCard filterCard) {
        this.filterCard = filterCard;
    }

    public CardEntity convertForHistory (Card card, String userBin, String timestamp) {
        return new CardEntity(userBin, card.getScheme(), card.getType(), card.getBank().getName(), timestamp);
    }

    public Map<String, String> convert (List<CardEntity> cardEntity) {
        Map<String, String> fromHistory = new LinkedHashMap<>();
        for (CardEntity entity : cardEntity) {
            fromHistory.put(entity.getBin(),
                    bankName(entity.getScheme()) + bankName(entity.getType()) +
                            bankName(entity.getBankName()) + entity.getTimestamp());
        }
        return filterCard.filterMap(fromHistory);
    }


    private String bankName(String string) {
        String value = "";
        if (string != null && !string.isEmpty()) {
            value = string + ", ";
        }
        return value;
    }
}
