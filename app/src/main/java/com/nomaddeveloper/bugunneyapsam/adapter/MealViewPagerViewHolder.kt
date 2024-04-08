package com.nomaddeveloper.bugunneyapsam.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nomaddeveloper.bugunneyapsam.R
import com.nomaddeveloper.bugunneyapsam.model.MealModel
import com.nomaddeveloper.bugunneyapsam.util.ImageLoaderUtil

class MealViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageLoader = ImageLoaderUtil()
    private val mealImageView: ImageView = itemView.findViewById(R.id.iv_viewpager_suggestion_meal_photo)
    private val mealNameTextView: TextView = itemView.findViewById(R.id.tv_viewpager_suggestion_meal_name)
    /*private val mealRatingTextView: TextView = itemView.findViewById(R.id.tv_adapter_meal_rating)
    private val mealCalorieTextView: TextView = itemView.findViewById(R.id.tv_adapter_meal_calorie)*/

    fun bindTo(meal: MealModel) {
        val calorie = "${meal.mealCalorie} kcal"
        /*mealRatingTextView.text = meal.mealRating.toString()
        mealCalorieTextView.text = calorie*/
        mealNameTextView.text = meal.mealName
        imageLoader.load(itemView.context, meal.mealPhoto, mealImageView)
    }
}