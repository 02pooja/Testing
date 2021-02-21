package com.example.testing.retrofit;

import com.example.testing.model.RowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("facts.json")
    Call<RowResponse> getNewsList();
}
