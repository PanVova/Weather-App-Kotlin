package com.example.weatherapi.di

import com.example.city.CityFragment
import com.example.core.di.AppComponent
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
