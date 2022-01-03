package com.weather.weatherapi.di

import com.weather.core.di.AppComponent
import com.weather.search.SearchFragment
import dagger.Component
import javax.inject.Scope

@SearchScope

@Component(dependencies = [AppComponent::class])
interface SearchComponent {
    fun inject(searchFragment: SearchFragment)
}

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class SearchScope
