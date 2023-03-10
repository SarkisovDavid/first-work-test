package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getCardMutableLiveData().observe(this, map -> Log.d(TAG, map.toString()));
                viewModel.loadCardInfo();

    }
}