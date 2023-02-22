package com.example.test;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private final ConverterMAP converterMAP = new ConverterMAP();
    private final MapExsample mMapExsample = new MapExsample();
    private final CompositeConverter mCompositeConverter = new CompositeConverter();
    private final MutableLiveData<List<Map.Entry<String, String>>> cardMutableLiveData = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Map.Entry<String, String>>> getCardMutableLiveData() {
        return cardMutableLiveData;
    }

    public void loadCardInfo(String bin) {
        Disposable disposable = ApiFactory.apiService.cardInfo(bin)
                .subscribeOn(Schedulers.io())
                .map(new Function<Card, Map<String, String>>() {
                    @Override
                    public Map<String, String> apply(Card card) {
                        return mCompositeConverter.mapMergeMap(card);
                    }
                })
                .flatMapObservable(new Function<Map<String, String>, ObservableSource<Map.Entry<String, String>>>() {
                    @Override
                    public ObservableSource<Map.Entry<String, String>> apply(Map<String, String> stringStringMap) throws Throwable {
                        return Observable.fromIterable(stringStringMap.entrySet());
                    }
                })
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Map.Entry<String, String>>>() {
                               @Override
                               public void accept(List<Map.Entry<String, String>> entries) {
                                   cardMutableLiveData.setValue(entries);
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) {
                                   Log.d("MainActivity", throwable.toString());
                               }
                           }
                );
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
