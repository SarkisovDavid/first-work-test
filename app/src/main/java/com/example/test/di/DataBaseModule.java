package com.example.test.di;
import android.content.Context;

import com.example.test.data.api.ApiFactory;
import com.example.test.data.api.ApiService;
import com.example.test.data.database.BinDao;
import com.example.test.data.database.BinDatabase;

import dagger.Module;
import dagger.Provides;


@Module
public class DataBaseModule {



    @Provides
    public BinDao provideBinDao(Context context) {
        return BinDatabase.getInstance(context).binDao();
    }

    @Provides
    public ApiService provideApiService(){
        return ApiFactory.apiServiceK;
    }
}
