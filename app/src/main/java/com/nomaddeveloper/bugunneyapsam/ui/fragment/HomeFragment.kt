package com.nomaddeveloper.bugunneyapsam.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.nomaddeveloper.bugunneyapsam.adapter.MealRecyclerAdapter
import com.nomaddeveloper.bugunneyapsam.databinding.FragmentHomeBinding
import com.nomaddeveloper.bugunneyapsam.model.MealModel
import com.nomaddeveloper.bugunneyapsam.util.ImageLoaderUtil

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mealRecyclerView: RecyclerView
    private lateinit var mealAdapter: MealRecyclerAdapter
    private lateinit var imageLoader: ImageLoaderUtil
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        imageLoader = ImageLoaderUtil()
        mealRecyclerView = binding.rvHomeFragmentMeals
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(mealRecyclerView)
        mealRecyclerView.layoutManager = layoutManager
        mealAdapter = MealRecyclerAdapter(mealList = createMealList(), imageLoader = imageLoader)
        mealRecyclerView.adapter = mealAdapter

        return binding.root
    }

    private fun createMealList(): ArrayList<MealModel> {
        return arrayListOf(
            MealModel(
                1,
                "Mercimek Çorbası",
                "https://images.pexels.com/photos/539451/pexels-photo-539451.jpeg",
                4.0,
                300
            ),
            MealModel(
                2,
                "Soslu Makarna",
                "https://images.pexels.com/photos/1487511/pexels-photo-1487511.jpeg",
                3.2,
                500
            ),
            MealModel(
                3,
                "Salata Tabağı",
                "https://images.pexels.com/photos/406152/pexels-photo-406152.jpeg",
                3.8,
                120
            ),
            MealModel(
                4,
                "Menemen",
                "https://images.pexels.com/photos/1854037/pexels-photo-1854037.jpeg",
                3.6,
                480
            ),
            MealModel(
                5,
                "Tavuk Şnitzel",
                "https://images.pexels.com/photos/1352270/pexels-photo-1352270.jpeg",
                3.3,
                400
            ),
            MealModel(
                6,
                "Domates Soslu Makarna",
                "https://images.pexels.com/photos/14737/pexels-photo.jpg",
                3.4,
                480
            )
        )
    }
}