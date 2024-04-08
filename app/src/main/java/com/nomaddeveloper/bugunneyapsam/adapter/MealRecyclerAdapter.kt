package com.nomaddeveloper.bugunneyapsam.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nomaddeveloper.bugunneyapsam.R
import com.nomaddeveloper.bugunneyapsam.model.MealModel
import com.nomaddeveloper.bugunneyapsam.util.ImageLoaderUtil

class MealRecyclerAdapter(private val mealList: ArrayList<MealModel>, private val imageLoader: ImageLoaderUtil) : RecyclerView.Adapter<MealViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item_home_fragment, parent, false)
        return MealViewHolder(view, imageLoader = imageLoader)
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = mealList[position]
        holder.bindTo(meal)
    }
}