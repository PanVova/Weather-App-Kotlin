package com.example.weatherapi.di

import com.example.core.di.AppComponent
import com.example.weatherapi.presentation.search.SearchFragment
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
