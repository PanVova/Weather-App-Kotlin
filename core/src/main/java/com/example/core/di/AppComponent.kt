package com.example.core.di

import android.app.Application
import com.example.data.WeatherAPI
import com.example.domain.gateway.WeatherGateway
import dagger.BindsInstance
import dagger.Component
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [BasicModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun baseUrl(@Named("baseUrl") baseUrl: String): Builder
        fun build(): AppComponent
    }

    fun inject(app: Application)

    fun getOkHttpClient(): OkHttpClient
    fun getLogging(): HttpLoggingInterceptor
    fun getRetrofit(): Retrofit
    fun getWeatherAPI(): WeatherAPI
    fun getWeatherGateway(): WeatherGateway
}