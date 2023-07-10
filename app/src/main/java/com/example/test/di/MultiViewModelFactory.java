package com.example.test.di;

import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MultiViewModelFactory implements ViewModelProvider.Factory {

    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelFactories;

    @Inject
    public MultiViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelFactories) {
        this.viewModelFactories = viewModelFactories;
    }

    public Set<Class<? extends ViewModel>> getViewModelClasses() {
        return viewModelFactories.keySet();
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Provider<ViewModel> provider = viewModelFactories.get(modelClass);
        if (provider == null) {
            throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass);
        }
        return (T) provider.get();
    }

}
