package com.example.test.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.test.presentation.HistoryBinActivity
import com.example.test.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataBaseModule::class])
interface AppComponent {

    fun getMap(): Map<Class<out ViewModel>, Provider<ViewModel>>

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context):AppComponent
    }

    fun inject(mainActivity: MainActivity)

    fun inject(historyBinActivity: HistoryBinActivity)
}