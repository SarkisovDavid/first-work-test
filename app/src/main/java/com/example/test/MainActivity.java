package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextBin;
    private Button buttonSearch;
    private MainViewModel viewModel;
    private RecyclerViewAdapter recyclerViewAdapter;
    public String userBin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userBin = editTextBin.getText().toString().trim();
                if (userBin.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.toast_no_data, Toast.LENGTH_SHORT).show();
                } else {
                    viewModel.loadCardInfo(userBin);
                }
            }
        });
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getCardMutableLiveData().observe(this, new Observer<List<CardInfoItemModel>>() {
            @Override
            public void onChanged(List<CardInfoItemModel> cardInfoItemModels) {
                recyclerViewAdapter.updateCardInfo(cardInfoItemModels);
                recyclerViewAdapter.setOnBankUrlClickListener(new RecyclerViewAdapter.OnBankUrlClickListener() {
                    @Override
                    public void onBankUrlClick(String url) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://" + url));
                        startActivity(intent);
                    }
                });
                recyclerViewAdapter.setOnBankPhoneClickListener(new RecyclerViewAdapter.OnBankPhoneClickListener() {
                    @Override
                    public void onBankPhoneClick(String phone) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + phone));
                        startActivity(intent);
                    }
                });
                recyclerViewAdapter.setOnBankMapClickListener(new RecyclerViewAdapter.OnBankMapClickListener() {
                    @Override
                    public void onBankMapClick(String map) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("geo:" + map));
                        startActivity(intent);
                    }
                });
            }
        });
    }

    private void initViews() {
        RecyclerView recyclerViewCardInfo = findViewById(R.id.recyclerViewCardInfo);
        recyclerViewAdapter = new RecyclerViewAdapter(Collections.<CardInfoItemModel>emptyList());
        editTextBin = findViewById(R.id.editTextBin);
        buttonSearch = findViewById(R.id.buttonSearch);
        recyclerViewCardInfo.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerViewCardInfo.setAdapter(recyclerViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.history_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemhistoryBin) {
            Intent intent = HistoryBinActivity.newIntent(this);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}