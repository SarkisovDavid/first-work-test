package com.example.test.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class MultiViewModelFactory @Inject constructor(private val viewModelFactories: Map<Class<out ViewModel>,
    @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {

    fun getViewModelClasses(): Set<Class<out ViewModel>> {
        return viewModelFactories.keys
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val provider = viewModelFactories[modelClass]
            ?: throw IllegalArgumentException("Unknown ViewModel class: + $modelClass")
        return provider.get() as T
    }
}