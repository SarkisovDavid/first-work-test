package com.example.test;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("45717360")
    Single<Card> cardInfo();

}
