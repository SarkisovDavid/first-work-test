package com.example.test;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private final ConverterMAP mConverterMAP = new ConverterMAP();
    private static final String TAG = "MainViewModel";
    private final MutableLiveData<Map<String, String>> cardMutableLiveData = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();


    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Map<String, String>> getCardMutableLiveData() {
        return cardMutableLiveData;
    }

    public void loadCardInfo() {
        Disposable disposable = ApiFactory.apiService.cardInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        card -> cardMutableLiveData.setValue(mConverterMAP.convert(card)),
                        throwable -> Log.d("MainActivity", throwable.toString())
                );
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
