package com.example.test.data.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory {

   companion object {
    private val BASE_URL = "https://lookup.binlist.net/"

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        @JvmField
        val apiService: ApiService = retrofit.create(ApiService::class.java)
    }
}