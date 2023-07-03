package com.example.test.di;

import com.example.test.BinDao;
import com.example.test.CardEntityConverter;
import com.example.test.HistoryBinViewModel;
import com.example.test.MainConverter;
import com.example.test.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

@Module
interface AppModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    ViewModel mainViewModel(MainViewModel mainViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HistoryBinViewModel.class)
    ViewModel HistoryBinViewModel(HistoryBinViewModel historyBinViewModel);


}
