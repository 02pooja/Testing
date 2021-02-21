package com.example.testing.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testing.model.RowResponse;
import com.example.testing.repository.RawRepsitory;

public class RawViewModel  extends ViewModel {
    private MutableLiveData<RowResponse> mutableLiveData;
    private RawRepsitory newsRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        newsRepository = RawRepsitory.getInstance();
        mutableLiveData = newsRepository.getNews();

    }

    public LiveData<RowResponse> getNewsRepository() {
        return mutableLiveData;
    }
}
