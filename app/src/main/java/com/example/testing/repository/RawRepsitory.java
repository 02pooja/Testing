package com.example.testing.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.testing.model.RowResponse;
import com.example.testing.retrofit.ApiClient;
import com.example.testing.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RawRepsitory {
    private static RawRepsitory newsRepository;

    public static RawRepsitory getInstance(){
        if (newsRepository == null){
            newsRepository = new RawRepsitory();
        }
        return newsRepository;
    }

    private ApiInterface newsApi;

    public RawRepsitory(){
        newsApi = ApiClient.cteateService(ApiInterface.class);
    }

    public MutableLiveData<RowResponse> getNews(){
        MutableLiveData<RowResponse> newsData = new MutableLiveData<>();
        newsApi.getNewsList().enqueue(new Callback<RowResponse>() {
            @Override
            public void onResponse(Call<RowResponse> call,
                                   Response<RowResponse> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RowResponse> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }
}
