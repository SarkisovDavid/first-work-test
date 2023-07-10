package com.example.test.di;

import android.content.Context;

import com.example.test.BinDao;
import com.example.test.BinDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class DataBaseModule {

    @Provides
    public BinDao provideBinDao(Context context) {
        return BinDatabase.getInstance(context).binDao();
    }
}
