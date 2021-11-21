package com.example.weatherapi.di

import com.example.core.di.AppComponent
import com.example.weatherapi.presentation.city.CityFragment
import dagger.Component
import dagger.Module
import javax.inject.Scope

@CityScope
@Component(dependencies = [AppComponent::class])
interface CityComponent {
    fun inject(cityFragment: CityFragment)
}

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class CityScope
