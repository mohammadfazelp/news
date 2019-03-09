package com.faz.samplejetpack.data.api;

import com.faz.samplejetpack.data.model.Feed;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Query;

/**
 * Created by PIRI on 1/22/2019.
 */
public interface RestApi {

    @GET("/v2/everything")
    Call<Feed> fetchFeed(@Query("q") String q,
                         @Query("apiKey") String apiKey,
                         @Query("page") long page,
                         @Query("pageSize") int pageSize);
}
