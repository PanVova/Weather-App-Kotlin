package com.weather.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.weather.city.databinding.FragmentCityBinding
import com.weather.core.di.DaggerAppComponent
import com.weather.core.utils.Constants
import com.weather.weatherapi.di.DaggerCityComponent
import javax.inject.Inject

class CityFragment : Fragment() {

    @Inject
    protected lateinit var viewModel: CityViewModel

    private lateinit var binding: FragmentCityBinding
    private lateinit var cityAdapter: CityAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCityBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerCityComponent
            .builder()
            .appComponent(
                DaggerAppComponent.builder().baseUrl("https://www.metaweather.com").build()
            )
            .build()
            .inject(this)


        setupRecyclerView()
        setupObservers()
        val cityId = arguments?.getInt(Constants.CITY_ID)!!

        viewModel.getCity(cityId)
    }

    private fun setupObservers() {
        viewModel.data.observe(viewLifecycleOwner) {
            onCityLoad(it)
        }
    }

    private fun setupRecyclerView() {
        cityAdapter = CityAdapter()
        with(binding) {
            weatherRecyclerView.layoutManager = LinearLayoutManager(context)
            weatherRecyclerView.adapter = cityAdapter
        }
    }

    private fun onCityLoad(weatherCity: com.weather.models.WeatherCity) {
        binding.cityName.text = weatherCity.title
        cityAdapter.setData(weatherCity.consolidated_weather)
    }
}