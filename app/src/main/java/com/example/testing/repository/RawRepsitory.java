package com.example.testing.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.testing.model.RowResponse;
import com.example.testing.retrofit.ApiClient;
import com.example.testing.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RawRepsitory {
    private static RawRepsitory rawRepository;

    public static RawRepsitory getInstance(){
        if (rawRepository == null){
            rawRepository = new RawRepsitory();
        }
        return rawRepository;
    }

    private ApiInterface rawApi;

    public RawRepsitory(){
        rawApi = ApiClient.cteateService(ApiInterface.class);
    }

    public MutableLiveData<RowResponse> getrawdata(){
        MutableLiveData<RowResponse> rawData = new MutableLiveData<>();
        rawApi.getRowList().enqueue(new Callback<RowResponse>() {
            @Override
            public void onResponse(Call<RowResponse> call,
                                   Response<RowResponse> response) {
                if (response.isSuccessful()){
                    rawData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RowResponse> call, Throwable t) {
                rawData.setValue(null);
            }
        });
        return rawData;
    }
}
