package com.nomaddeveloper.yunusloginclient

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.nomaddeveloper.accessmanager.AccessManager
import com.nomaddeveloper.yunusloginclient.databinding.ActivityLoginBinding
import com.nomaddeveloper.yunusloginclient.util.ToastUtil

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignIn: AppCompatButton
    private lateinit var accessManager: AccessManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        accessManager = AccessManager()
        prepareUI()

        btnSignIn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == btnSignIn.id) {
            if (BuildConfig.TEST_ENABLED) {
                intentToActivity(MainActivity())
            } else if (isAuthenticated()) {
                intentToActivity(MainActivity())
            } else {
                ToastUtil().makeToast(this@LoginActivity, "not authorized")
            }
        }
    }


    private fun prepareUI() {
        binding.apply {
            etUsername = this.etTilActivityMainUsername
            etPassword = this.etTilActivityMainPassword
            btnSignIn = this.btnActivityMainAuthenticate
        }
    }

    private fun isAuthenticated(): Boolean {
        return accessManager.authenticate(etUsername.text.toString(), etPassword.text.toString())
    }

    private fun intentToActivity(activity: Activity) {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }
}