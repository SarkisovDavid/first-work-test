package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Collections;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCardInfo;
    private static final String TAG = "MainActivity";
    private MainViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCardInfo = findViewById(R.id.recyclerViewCardInfo);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, Collections.emptyList());
        recyclerViewCardInfo.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerViewCardInfo.setAdapter(recyclerViewAdapter);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getCardMutableLiveData().observe(this, new Observer<List<Map.Entry<String, String>>>() {
            @Override
            public void onChanged(List<Map.Entry<String, String>> stringStringMap) {
                recyclerViewAdapter.updateCardInfo(stringStringMap);
            }
        });
        viewModel.loadCardInfo();
    }
}