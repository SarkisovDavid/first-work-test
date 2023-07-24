package com.example.test.di

import android.content.Context
import com.example.test.data.api.ApiFactory
import com.example.test.data.api.ApiService
import com.example.test.data.database.BinDao
import com.example.test.data.database.BinDatabase
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {

    @Provides
    fun provideBinDao(context: Context): BinDao {
        return BinDatabase.getInstance(context).binDao();
    }

    @Provides
    fun  provideApiService(): ApiService {
        return ApiFactory.apiService;
    }
}