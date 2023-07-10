package com.example.test;

import android.app.Application;

import com.example.test.di.AppComponent;
import com.example.test.di.DaggerAppComponent;

public class App extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.factory().create(this);
    }
}
