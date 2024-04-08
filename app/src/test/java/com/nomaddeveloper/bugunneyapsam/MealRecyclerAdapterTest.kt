package com.nomaddeveloper.bugunneyapsam

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nomaddeveloper.bugunneyapsam.adapter.MealRecyclerAdapter
import com.nomaddeveloper.bugunneyapsam.model.MealModel
import com.nomaddeveloper.bugunneyapsam.util.ImageLoaderUtil
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class MealRecyclerAdapterTest {
    @Mock
    private lateinit var mockContext: Context
    private lateinit var imageLoader: ImageLoaderUtil

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var adapterWithMeals: MealRecyclerAdapter
    private lateinit var adapterWithEmptyMeals: MealRecyclerAdapter
    private lateinit var meals: ArrayList<MealModel>
    private lateinit var emptyMeals: ArrayList<MealModel>
    private lateinit var parent: ViewGroup
    private lateinit var itemView: View
    private lateinit var mockMeal: MealModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        imageLoader = ImageLoaderUtil()
        meals = arrayListOf(
            MealModel(1, "Meal 1", "photo1.jpg", 4.5, 300),
            MealModel(2, "Meal 2", "photo2.jpg", 4.0, 350),
            MealModel(3, "Meal 3", "photo3.jpg", 4.8, 400)
        )
        mockMeal = MealModel(61, "Test Meal", mockContext.getString(R.drawable.test), 4.0, 500)
        emptyMeals = ArrayList()
        adapterWithMeals = MealRecyclerAdapter(meals, imageLoader)
        adapterWithEmptyMeals = MealRecyclerAdapter(emptyMeals, imageLoader)
        parent = mock<ViewGroup>(ViewGroup::class.java)
        itemView = mock<View>(View::class.java)
    }

    @Test
    fun getItemCount_withEmptyList_returnsZero() {
        val itemCount = adapterWithEmptyMeals.itemCount
        assertEquals(0, itemCount)
    }

    @Test
    fun getItemCount_withNonEmptyList_returnsCorrectCount() {
        val itemCount = adapterWithMeals.itemCount
        assertEquals(meals.size, itemCount)
    }

    @Test
    fun addMeals_increasesItemCount() {
        val initialItemCount = adapterWithEmptyMeals.itemCount
        val updatedItemCount = adapterWithMeals.itemCount
        assertEquals(initialItemCount + meals.size, updatedItemCount)
    }

    @Test
    fun testViewHolderBinding() {
        TODO()
    }

    @Test
    fun testAdapterBinding() {
        TODO()
    }
}
