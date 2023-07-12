package com.example.test.domain.usecase;

import com.example.test.data.model.CardDto;
import com.example.test.domain.model.CardInfoItemModel;
import com.example.test.domain.repository.CardRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class GetCardInfo {

    CardRepository cardRepository;

    @Inject
    public GetCardInfo(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Single<List<CardInfoItemModel>> execute(String bin){
        return cardRepository.getCardInfo(bin);
    }
}
