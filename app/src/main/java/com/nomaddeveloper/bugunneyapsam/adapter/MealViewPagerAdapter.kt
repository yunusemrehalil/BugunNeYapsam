package com.nomaddeveloper.bugunneyapsam.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nomaddeveloper.bugunneyapsam.R
import com.nomaddeveloper.bugunneyapsam.model.MealModel

class MealViewPagerAdapter(private val items: List<MealModel>) :
    RecyclerView.Adapter<MealViewPagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item_suggestion_fragment, parent, false)
        return MealViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewPagerViewHolder, position: Int) {
        val meal = items[position]
        holder.bindTo(meal)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}