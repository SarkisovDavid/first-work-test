package com.example.test;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HistoryBinViewModel extends ViewModel {

    private BinDao binDao;

    private CardEntityConverter cardEntityConverter;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final MutableLiveData<List<Map.Entry<String, String>>> historyMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Map.Entry<String, String>>> getHistoryMutableLiveData() {
        return historyMutableLiveData;
    }

    @Inject
    public HistoryBinViewModel(BinDao binDao, CardEntityConverter cardEntityConverter) {
        this.binDao = binDao;
        this.cardEntityConverter = cardEntityConverter;
    }

    public void getHistoryBin() {
        Disposable disposable = binDao.getHistoryCardBin()
                .subscribeOn(Schedulers.io())
                .map(new Function<List<CardEntity>, List<Map.Entry<String, String>>>() {
                    @Override
                    public List<Map.Entry<String, String>> apply(List<CardEntity> cardEntities) {
                        return new ArrayList<>(cardEntityConverter.convert(cardEntities).entrySet());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Map.Entry<String, String>>>() {
                    @Override
                    public void accept(List<Map.Entry<String, String>> entries) {
                        historyMutableLiveData.setValue(entries);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.d("HistoryBinViewModel", "Throwable " + throwable.getMessage());
                    }
                });
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
