package com.example.test.domain.repository;

import com.example.test.domain.model.CardInfoItemModel;

import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Single;

public interface CardRepository {

    Single<List<CardInfoItemModel>> getCardInfo(String bin);

    Single<List<Map.Entry<String, String>>> getHistoryCard();

}
