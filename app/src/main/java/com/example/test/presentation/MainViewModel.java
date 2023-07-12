package com.example.test.presentation;

import com.example.test.domain.model.CardInfoItemModel;
import com.example.test.domain.usecase.GetCardInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;


import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    GetCardInfo getCardInfo;
    private final MutableLiveData<List<CardInfoItemModel>> cardMutableLiveData = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public MainViewModel(GetCardInfo getCardInfo) {
        this.getCardInfo = getCardInfo;
    }

    public LiveData<List<CardInfoItemModel>> getCardMutableLiveData() {
        return cardMutableLiveData;
    }

    public void loadCardInfo(String bin) {
        Disposable disposable = getCardInfo.execute(bin)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<CardInfoItemModel>>() {
                    @Override
                    public void accept(List<CardInfoItemModel> cardInfoItemModels) {
                        cardMutableLiveData.setValue(cardInfoItemModels);
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
