package com.example.test.di;

import com.example.test.BinDao;
import com.example.test.CardEntityConverter;
import com.example.test.MainConverter;
import com.example.test.MainViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

//public class ViewModelFactory implements ViewModelProvider.Factory {
//
//    private MainConverter mMainConverter;
//
//    private CardEntityConverter mCardEntityConverter;
//    private BinDao binDao;
//
//    @Inject
//    public ViewModelFactory(MainConverter mMainConverter, CardEntityConverter mCardEntityConverter, BinDao binDao) {
//        this.mMainConverter = mMainConverter;
//        this.mCardEntityConverter = mCardEntityConverter;
//        this.binDao = binDao;
//    }
//
//    @NonNull
//    @Override
//    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        return (T) new MainViewModel(mMainConverter, mCardEntityConverter, binDao);
//    }
//}
