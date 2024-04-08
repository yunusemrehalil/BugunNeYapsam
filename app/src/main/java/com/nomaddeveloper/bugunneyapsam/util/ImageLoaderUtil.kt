package com.nomaddeveloper.bugunneyapsam.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.nomaddeveloper.bugunneyapsam.listener.ImageLoader

class ImageLoaderUtil : ImageLoader {
    override fun load(context: Context?, path: String?, imageView: ImageView?) {
        Glide.with(context!!)
            .load(path)
            .centerCrop()
            .into(imageView!!)
    }
}