package com.example.test;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HistoryBinViewModel extends AndroidViewModel {

    private final BinDao binDao;
    private final CardEntityConverter cardEntityConverter = new CardEntityConverter();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final MutableLiveData<List<Map.Entry<String, String>>> historyMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Map.Entry<String, String>>> getHistoryMutableLiveData() {
        return historyMutableLiveData;
    }

    public HistoryBinViewModel(@NonNull Application application) {
        super(application);
        binDao = BinDatabase.getInstance(application).binDao();
    }

    public void getHistoryBin () {
        Disposable disposable = binDao.getHistoryCardBin()
                .subscribeOn(Schedulers.io())
                .map(new Function<List<CardEntity>, List<Map.Entry<String, String>>> () {
                    @Override
                    public List<Map.Entry<String, String>> apply(List<CardEntity> cardEntities){
                        return new ArrayList<>(cardEntityConverter.convert(cardEntities).entrySet());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Map.Entry<String, String>>>() {
                    @Override
                    public void accept(List<Map.Entry<String, String>> entries) {
                        historyMutableLiveData.setValue(entries);
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
