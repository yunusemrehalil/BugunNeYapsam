package com.nomaddeveloper.bugunneyapsam.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.nomaddeveloper.bugunneyapsam.BaseFragment
import com.nomaddeveloper.bugunneyapsam.R
import com.nomaddeveloper.bugunneyapsam.ShadowTransformer
import com.nomaddeveloper.bugunneyapsam.adapter.MealViewPagerAdapter
import com.nomaddeveloper.bugunneyapsam.databinding.FragmentSuggestionBinding
import com.nomaddeveloper.bugunneyapsam.model.MealModel

class SuggestionsFragment : BaseFragment() {
    private lateinit var binding: FragmentSuggestionBinding
    private lateinit var mealViewPager: ViewPager2
    private lateinit var mealViewPagerAdapter: MealViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuggestionBinding.inflate(layoutInflater)
        mealViewPager = binding.vpHomeFragmentMeals
        mealViewPagerAdapter = MealViewPagerAdapter(createMealList())
        mealViewPager.adapter = mealViewPagerAdapter
        val transformer = ShadowTransformer(3)
        mealViewPager.setPageTransformer(transformer)

        return binding.root
    }
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