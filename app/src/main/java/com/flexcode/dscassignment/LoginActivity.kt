package com.flexcode.dscassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //intent for forgot password
        tvForgotPassword.setOnClickListener( View.OnClickListener {
            val intent = Intent(this@LoginActivity, ForgotPassword::class.java)
            startActivity(intent)
            onBackPressed()
        })

        //Intent for signup page
        tvSignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, CreateAccount::class.java)
            startActivity(intent)
            onBackPressed()
        }

        //login on click listener
        btnLogin.setOnClickListener { checkEmail() }

    }

    private fun checkEmail() {
        val email = etEmail.text.toString().trim()
        if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches() ){
            return
        }else {
            etEmail.error = getString(R.string.invalid)
        }
    }
}