package com.example.test.domain.usecase;

import com.example.test.data.model.CardEntity;
import com.example.test.domain.model.CardInfoItemModel;
import com.example.test.domain.repository.CardRepository;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class GetHistory {

    CardRepository cardRepository;

    @Inject
    public GetHistory(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Single<List<Map.Entry<String, String>>> execute(){
        return cardRepository.getHistoryCard();
    }
}
