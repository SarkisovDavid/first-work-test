package com.example.test.di;

import android.content.Context;

import com.example.test.MainActivity;
import com.example.test.MainViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    @Component.Factory
    interface Factory {
        AppComponent create (@BindsInstance Context context);
    }

    void inject(MainActivity mainActivity);

//    Inject inject(MainViewModel mainViewModel);

}
