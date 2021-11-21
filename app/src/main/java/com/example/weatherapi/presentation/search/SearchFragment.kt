package com.example.weatherapi.presentation.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.di.DaggerAppComponent
import com.example.weatherapi.R
import com.example.weatherapi.databinding.FragmentSearchBinding
import com.example.core.utils.Constants
import com.example.weatherapi.di.DaggerSearchComponent
import javax.inject.Inject

class SearchFragment : Fragment() {

    @Inject
    protected lateinit var viewModel: SearchViewModel
    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        DaggerSearchComponent
            .builder()
            .appComponent(DaggerAppComponent.builder().baseUrl("https://www.metaweather.com").build())
            .build()
            .inject(this)



        setupView()
        setupObservers()
        setupRecyclerView()
    }


    private fun setupView() {
        with(binding) {
            searchCity.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    updateSearchText(s.toString())
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })

            sendQuery.setOnClickListener {
                viewModel.getCities(searchCity.text.toString())
            }
        }
    }

    private fun setupObservers() {
        viewModel.data.observe(viewLifecycleOwner) {
            onCitiesLoad(it)
        }
    }

    private fun setupRecyclerView() {
        with(binding) {
            searchAdapter = SearchAdapter() {
                val bundle = Bundle().apply { putInt(Constants.CITY_ID, it.woeid) }
                findNavController().navigate(R.id.searchFragment_cityFragment, bundle)
            }
            with(searchRecyclerView) {
                layoutManager = LinearLayoutManager(context)
                adapter = searchAdapter
            }
        }
    }

    private fun onCitiesLoad(list: List<com.example.models.City>) {
        searchAdapter.setData(list)
    }


    private fun updateSearchText(text: String) {
        searchAdapter.updateSearchText(text)
    }
}