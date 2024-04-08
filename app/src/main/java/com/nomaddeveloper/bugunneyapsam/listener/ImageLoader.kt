package com.nomaddeveloper.bugunneyapsam.listener

import android.content.Context
import android.widget.ImageView

interface ImageLoader {
    fun load(
        context: Context?,
        path: String?,
        imageView: ImageView?
    )
    // TODO() add placeholder
}