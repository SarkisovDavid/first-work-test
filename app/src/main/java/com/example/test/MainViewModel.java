package com.example.test;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private final MainConverter mMainConverter = new MainConverter();
    private final CardEntityConverter mCardEntityConverter = new CardEntityConverter();
    private final MutableLiveData<List<CardInfoItemModel>> cardMutableLiveData = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final BinDao binDao = BinDatabase.getInstance(getApplication()).binDao();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<CardInfoItemModel>> getCardMutableLiveData() {
        return cardMutableLiveData;
    }

    public void loadCardInfo(String bin) {
        Disposable disposable = ApiFactory.apiService.cardInfo(bin)
                .subscribeOn(Schedulers.io())
                .doOnSuccess(new Consumer<Card>() {
                    @Override
                    public void accept(Card card) {
                        Date date = new Date();
                        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        CardEntity history = mCardEntityConverter.convertForHistory(card, bin, format.format(date));
                        binDao.insertBin(history);
                    }
                })
                .map(new Function<Card, List<CardInfoItemModel>>() {
                    @Override
                    public List<CardInfoItemModel> apply(Card card) throws Throwable {
                        return mMainConverter.convert(card);
                    }
                })
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
