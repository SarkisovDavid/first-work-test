package com.example.test.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.test.App;
import com.example.test.R;
import com.example.test.di.MultiViewModelFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

public class HistoryBinActivity extends AppCompatActivity {

    @Inject
    MultiViewModelFactory multiViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App app = (App) getApplication();
        app.appComponent.inject(this);
        setContentView(R.layout.activity_history_bin);
        RecyclerView recyclerViewHistory = findViewById(R.id.recyclerViewHistory);
        HistoryRecyclerViewAdapter recyclerViewAdapter = new HistoryRecyclerViewAdapter(HistoryBinActivity.this, Collections.emptyList());
        recyclerViewHistory.setLayoutManager(new LinearLayoutManager(HistoryBinActivity.this));
        recyclerViewHistory.setAdapter(recyclerViewAdapter);
        HistoryBinViewModel viewModel = new ViewModelProvider(this, multiViewModelFactory).get(HistoryBinViewModel.class);
        viewModel.getHistoryBin();
        viewModel.getHistoryMutableLiveData().observe(this, new Observer<List<Map.Entry<String, String>>>() {
            @Override
            public void onChanged(List<Map.Entry<String, String>> entries) {
                recyclerViewAdapter.updateCardInfo(entries);
            }
        });
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, HistoryBinActivity.class);
    }
}