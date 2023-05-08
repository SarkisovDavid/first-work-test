package com.example.test.di;

import android.content.Context;

import com.example.test.BinDao;
import com.example.test.BinDatabase;
import com.example.test.CardEntityConverter;
import com.example.test.MainConverter;
import com.example.test.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    public MainConverter provideMainConverter() {
        return new MainConverter();
    }

    @Provides
    public CardEntityConverter provideCardEntityConverter() {
        return new CardEntityConverter();
    }

    @Provides
    public BinDao provideBinDao(Context context) {
        return BinDatabase.getInstance(context).binDao();
    }

    @Provides
    public MainViewModel provideMainViewModel(MainConverter mainConverter, CardEntityConverter cardEntityConverter,  BinDao binDao) {
        return new MainViewModel(mainConverter, cardEntityConverter, binDao);
    }

}
