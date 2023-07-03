package com.example.test.di;

import android.content.Context;

import com.example.test.HistoryBinActivity;
import com.example.test.MainActivity;

import java.util.Map;
import java.util.Set;

import javax.inject.Provider;
import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataBaseModule.class})
public interface AppComponent {

    Map<Class<? extends ViewModel>, Provider<ViewModel>> getMap();
    @Component.Factory
    interface Factory {
        AppComponent create (@BindsInstance Context context);
    }

    void inject(MainActivity mainActivity);

    void inject(HistoryBinActivity historyBinActivity);


}
