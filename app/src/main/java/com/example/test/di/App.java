package com.example.test.di;

import android.app.Application;

import dagger.Component;

public class App extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.factory().create(this);
    }
}
