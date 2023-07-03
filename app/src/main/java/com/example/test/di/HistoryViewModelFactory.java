package com.example.test.di;

import com.example.test.BinDao;
import com.example.test.CardEntityConverter;
import com.example.test.HistoryBinViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

//public class HistoryViewModelFactory implements ViewModelProvider.Factory {
//
//    private BinDao binDao;
//
//    private CardEntityConverter cardEntityConverter;
//
//    @Inject
//    public HistoryViewModelFactory(BinDao binDao, CardEntityConverter cardEntityConverter) {
//        this.binDao = binDao;
//        this.cardEntityConverter = cardEntityConverter;
//    }
//
//    @NonNull
//    @Override
//    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        return (T) new HistoryBinViewModel(binDao, cardEntityConverter);
//    }
//}
