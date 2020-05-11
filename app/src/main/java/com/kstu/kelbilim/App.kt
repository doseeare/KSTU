package com.kstu.kelbilim

import android.app.Application
import com.kstu.kelbilim.service.AppPreferences
import org.koin.android.ext.koin.androidContext
import com.kstu.kelbilim.di.viewModelModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppPreferences.init(this)
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(getModule())
        }

    }

    private fun getModule(): List<Module> {
        return listOf(viewModelModule)
    }
}