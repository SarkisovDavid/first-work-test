package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HistoryBinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_bin);
        RecyclerView recyclerViewHistory = findViewById(R.id.recyclerViewHistory);
        HistoryRecyclerViewAdapter recyclerViewAdapter = new HistoryRecyclerViewAdapter(HistoryBinActivity.this, Collections.emptyList());
        recyclerViewHistory.setLayoutManager(new LinearLayoutManager(HistoryBinActivity.this));
        recyclerViewHistory.setAdapter(recyclerViewAdapter);
        HistoryBinViewModel viewModel = new ViewModelProvider(this).get(HistoryBinViewModel.class);
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