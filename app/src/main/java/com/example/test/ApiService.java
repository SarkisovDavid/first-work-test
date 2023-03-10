package com.example.test;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {


    @GET("{BIN}")
    Single<Card> cardInfo(@Path("BIN") String BIN);
}
