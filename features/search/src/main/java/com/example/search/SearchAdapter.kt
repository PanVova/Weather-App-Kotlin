package com.example.search

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.models.City
import com.example.search.databinding.SearchItemBinding

class SearchAdapter(private val clickListener: (City) -> Unit) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private val cities = mutableListOf<City>()
    private lateinit var searchText: String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.search_item, parent, false)
        )
    }

    fun setData(cityList: List<City>) {
        cities.clear()
        cities.addAll(cityList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = cities.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(cities[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = SearchItemBinding.bind(view)
        private val cityName = binding.cityName

        fun bind(city: City) {
            binding.root.setOnClickListener { clickListener.invoke(city) }

            val index = city.name.indexOf(searchText)
            cityName.text = SpannableStringBuilder(city.name).apply {
                if (index > 0) {
                    setSpan(
                        StyleSpan(Typeface.BOLD),
                        index,
                        index + searchText.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
            }
        }
    }

    fun updateSearchText(searchText: String) {
        this.searchText = searchText
    }
}