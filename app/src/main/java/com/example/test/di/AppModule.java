package com.example.test.di;
import com.example.test.presentation.HistoryBinViewModel;
import com.example.test.presentation.MainViewModel;
import com.example.test.data.repository.CardRepositoryImpl;
import com.example.test.domain.repository.CardRepository;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
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

    @Binds
    CardRepository provideCardRepository(CardRepositoryImpl cardRepositoryImpl);

}
