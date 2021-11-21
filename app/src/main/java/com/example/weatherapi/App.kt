package com.example.weatherapi

import android.app.Application
import com.example.core.di.AppComponent
import com.example.core.di.DaggerAppComponent
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        component = DaggerAppComponent
            .builder()
            .baseUrl("https://www.metaweather.com")
            .build()
        component.inject(this)
    }

    companion object {
        lateinit var component: AppComponent
    }
}