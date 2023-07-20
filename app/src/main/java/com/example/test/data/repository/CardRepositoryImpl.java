package com.example.test.data.repository;

import android.annotation.SuppressLint;

import com.example.test.data.api.ApiService;
import com.example.test.data.api.MainConverter;
import com.example.test.data.database.CardEntityConverter;
import com.example.test.data.database.BinDao;
import com.example.test.data.model.CardDto;
import com.example.test.data.model.CardEntity;
import com.example.test.domain.model.CardInfoItemModel;
import com.example.test.domain.repository.CardRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;

public class CardRepositoryImpl implements CardRepository {


    MainConverter mainConverterK;
    ApiService apiServiceK;
    BinDao binDao;
    CardEntityConverter cardEntityConverter;

    @Inject
    public CardRepositoryImpl
            (
                    ApiService apiServiceK,
                    MainConverter mainConverterK,
                    BinDao binDao,
                    CardEntityConverter cardEntityConverter
            ) {
        this.apiServiceK = apiServiceK;
        this.mainConverterK = mainConverterK;
        this.binDao = binDao;
        this.cardEntityConverter = cardEntityConverter;
    }

    @Override
    public Single<List<CardInfoItemModel>> getCardInfo(String bin) {
        return apiServiceK.cardInfo(bin)
                .doOnSuccess(new Consumer<CardDto>() {
                    @Override
                    public void accept(CardDto card) {
                        Date date = new Date();
                        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        CardEntity history = cardEntityConverter.convertForHistory(card, bin, format.format(date));
                        binDao.insertBin(history);
                    }
                })
                .map(new Function<CardDto, List<CardInfoItemModel>>() {
            @Override
            public List<CardInfoItemModel> apply(CardDto cardDto) throws Throwable {
                return mainConverterK.convert(cardDto);
            }
        });
    }

    @Override
    public Single<List<Map.Entry<String, String>>> getHistoryCard() {
        return binDao.getHistoryCardBin()
                .map(new Function<List<CardEntity>, List<Map.Entry<String, String>>>() {
                    @Override
                    public List<Map.Entry<String, String>> apply(List<CardEntity> cardEntities) throws Throwable {
                        return new ArrayList<>(cardEntityConverter.convert(cardEntities).entrySet());
                    }
                });
    }
}
