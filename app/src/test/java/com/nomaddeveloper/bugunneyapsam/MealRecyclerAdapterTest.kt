package com.nomaddeveloper.bugunneyapsam

import com.nomaddeveloper.bugunneyapsam.adapter.MealRecyclerAdapter
import com.nomaddeveloper.bugunneyapsam.model.MealModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MealRecyclerAdapterTest {
    private lateinit var meals: ArrayList<MealModel>
    private lateinit var emptyMeals: ArrayList<MealModel>
    private lateinit var adapter: MealRecyclerAdapter

    @Before
    fun setup() {
        meals = arrayListOf(
            MealModel(1, "Meal 1", "photo1.jpg", 4.5, 300),
            MealModel(2, "Meal 2", "photo2.jpg", 4.0, 350),
            MealModel(3, "Meal 3", "photo3.jpg", 4.8, 400)
        )
        emptyMeals = ArrayList()
        adapter = MealRecyclerAdapter(emptyMeals)
    }

    @Test
    fun getItemCount_withEmptyList_returnsZero() {
        val itemCount = adapter.itemCount
        assertEquals(0, itemCount)
    }

    @Test
    fun getItemCount_withNonEmptyList_returnsCorrectCount() {
        adapter = MealRecyclerAdapter(meals)
        val itemCount = adapter.itemCount
        assertEquals(meals.size, itemCount)
    }

    @Test
    fun addMeals_increasesItemCount() {
        val initialItemCount = adapter.itemCount
        adapter = MealRecyclerAdapter(meals)
        val updatedItemCount = adapter.itemCount
        assertEquals(initialItemCount + meals.size, updatedItemCount)
    }
}
