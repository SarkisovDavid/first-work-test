package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private EditText editTextBin;
    private Button buttonSearch;
    private MainViewModel viewModel;
    private RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userBin = editTextBin.getText().toString().trim();
                if (userBin.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.toast_no_data, Toast.LENGTH_SHORT).show();
                } else {
                    viewModel.loadCardInfo(userBin);
                }
            }
        });
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getCardMutableLiveData().observe(this, new Observer<List<Map.Entry<String, String>>>() {
            @Override
            public void onChanged(List<Map.Entry<String, String>> stringStringMap) {
                recyclerViewAdapter.updateCardInfo(stringStringMap);
            }
        });
    }

    private void initViews() {
        RecyclerView recyclerViewCardInfo = findViewById(R.id.recyclerViewCardInfo);
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, Collections.emptyList());
        editTextBin = findViewById(R.id.editTextBin);
        buttonSearch = findViewById(R.id.buttonSearch);
        recyclerViewCardInfo.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerViewCardInfo.setAdapter(recyclerViewAdapter);
    }
}