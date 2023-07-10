package com.example.test.di;

import com.example.test.HistoryBinViewModel;
import com.example.test.MainViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

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
