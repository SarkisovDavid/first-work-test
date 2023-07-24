package com.example.test.data.api

import com.example.test.data.model.CardDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{BIN}")
    fun cardInfo(@Path("BIN") bin: String?): Single<CardDto>
}