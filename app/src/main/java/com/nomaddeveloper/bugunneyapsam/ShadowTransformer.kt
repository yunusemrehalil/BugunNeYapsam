package com.nomaddeveloper.bugunneyapsam

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class ShadowTransformer(private val offscreenPageLimit: Int) : ViewPager2.PageTransformer {

    companion object {
        private const val DEFAULT_TRANSLATION_X = .0f
        private const val DEFAULT_TRANSLATION_FACTOR = 1.46f
        private const val SCALE_FACTOR = .14f
        private const val DEFAULT_SCALE = 1f
    }

    override fun transformPage(page: View, position: Float) {

        page.apply {
            ViewCompat.setElevation(page, -abs(position))
            val scaleFactor = -SCALE_FACTOR * position + DEFAULT_SCALE
            when (position) {
                in 0f..<offscreenPageLimit.toFloat() -> {
                    scaleX = scaleFactor
                    scaleY = scaleFactor
                    translationX = -(width / DEFAULT_TRANSLATION_FACTOR) * position
                }

                else -> {
                    translationX = DEFAULT_TRANSLATION_X
                    scaleX = DEFAULT_SCALE
                    scaleY = DEFAULT_SCALE
                }
            }

            val recommendedMealPhotoIV: ImageView =
                findViewById(R.id.iv_viewpager_suggestion_meal_photo)
            val recommendedMealNameTV: TextView =
                findViewById(R.id.tv_viewpager_suggestion_meal_name)
            if (position <= -1.0f || position >= 1.0f) {
                recommendedMealPhotoIV.alpha = 0.5f
                recommendedMealNameTV.alpha = 0.5f
            } else if (position == 0.5f) {
                recommendedMealPhotoIV.alpha = 1.0f
                recommendedMealNameTV.alpha = 1.0f
            } else if (position < 0.5f) {
                recommendedMealPhotoIV.alpha = 1.0f - abs(position)
                recommendedMealNameTV.alpha = 1.0f - abs(position)
            }
        }
    }
}



