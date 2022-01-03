package com.weather.weatherapi.di

import com.weather.city.CityFragment
import com.weather.core.di.AppComponent
import dagger.Component
import javax.inject.Scope

@CityScope
@Component(dependencies = [AppComponent::class])
interface CityComponent {
    fun inject(cityFragment: CityFragment)
}

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class CityScope
