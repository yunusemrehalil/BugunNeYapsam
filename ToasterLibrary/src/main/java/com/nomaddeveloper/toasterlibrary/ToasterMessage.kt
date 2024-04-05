package com.nomaddeveloper.toasterlibrary

import android.content.Context
import android.widget.Toast

class ToasterMessage {
    fun toast(context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}