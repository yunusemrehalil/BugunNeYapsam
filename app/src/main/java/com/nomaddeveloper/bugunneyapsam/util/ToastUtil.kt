package com.nomaddeveloper.bugunneyapsam.util

import android.content.Context
import android.widget.Toast

class ToastUtil {
    fun makeToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}