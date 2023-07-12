package com.example.test.data.api;

import com.example.test.data.model.CardDto;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {


    @GET("{BIN}")
    Single<CardDto> cardInfo(@Path("BIN") String bin);

}
