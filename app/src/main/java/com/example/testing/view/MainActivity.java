package com.example.testing.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testing.R;
import com.example.testing.adapter.RawAdapter;
import com.example.testing.model.RawModel;
import com.example.testing.viewModel.RawViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<RawModel> raweArrayList = new ArrayList<>();
    RawAdapter rawAdapter;
    RecyclerView rvHeadline;
    RawViewModel rawViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeadline = findViewById(R.id.rView);
        rawViewModel = ViewModelProviders.of(this).get(RawViewModel.class);
        rawViewModel.init();
        rawViewModel.getRawRepository().observe(this, newsResponse -> {
        List<RawModel> newsArticles = newsResponse.getRows();
            raweArrayList.addAll(newsArticles);
            rawAdapter.notifyDataSetChanged();
        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        if (rawAdapter == null) {
            rawAdapter = new RawAdapter(MainActivity.this, raweArrayList);
            rvHeadline.setLayoutManager(new LinearLayoutManager(this));
            rvHeadline.setAdapter(rawAdapter);
            rvHeadline.setItemAnimator(new DefaultItemAnimator());
            rvHeadline.setNestedScrollingEnabled(true);
        } else {
            rawAdapter.notifyDataSetChanged();
        }
    }

}