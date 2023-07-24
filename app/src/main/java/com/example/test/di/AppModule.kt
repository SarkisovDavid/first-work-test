package com.example.test.di

import androidx.lifecycle.ViewModel
import com.example.test.data.repository.CardRepositoryImpl
import com.example.test.domain.repository.CardRepository
import com.example.test.presentation.HistoryBinViewModel
import com.example.test.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface AppModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun mainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HistoryBinViewModel::class)
    fun historyBinViewModel(historyBinViewModel: HistoryBinViewModel): ViewModel

    @Binds
    fun provideCardRepository(cardRepositoryImpl: CardRepositoryImpl): CardRepository
}