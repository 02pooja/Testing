package com.example.testing.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testing.model.RowResponse;
import com.example.testing.repository.RawRepsitory;

public class RawViewModel  extends ViewModel {
    private MutableLiveData<RowResponse> mutableLiveData;
    private RawRepsitory rawRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        rawRepository = RawRepsitory.getInstance();
        mutableLiveData = rawRepository.getrawdata();

    }

    public LiveData<RowResponse> getRawRepository() {
        return mutableLiveData;
    }
}
