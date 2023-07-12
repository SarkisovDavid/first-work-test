package com.example.test.presentation;

import android.util.Log;

import com.example.test.domain.usecase.GetHistory;

import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.Map;


import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HistoryBinViewModel extends ViewModel {

    private GetHistory getHistory;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final MutableLiveData<List<Map.Entry<String, String>>> historyMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Map.Entry<String, String>>> getHistoryMutableLiveData() {
        return historyMutableLiveData;
    }

    @Inject
    public HistoryBinViewModel(GetHistory getHistory) {
        this.getHistory = getHistory;
    }

    public void getHistoryBin() {
        Disposable disposable = getHistory.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Map.Entry<String, String>>>() {
                    @Override
                    public void accept(List<Map.Entry<String, String>> entries) throws Throwable {
                        historyMutableLiveData.setValue(entries);
                    }
                },
                new Consumer<Throwable>() {
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
