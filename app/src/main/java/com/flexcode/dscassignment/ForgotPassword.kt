package com.flexcode.dscassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_forgot_password.etEmail
import kotlinx.android.synthetic.main.activity_login.*

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)



        //Intent to login page back btn
       ivBack_Details.setOnClickListener {
           val intent = Intent(this@ForgotPassword, LoginActivity::class.java)
           startActivity(intent)
           onBackPressed()
       }
        btnSubmit.setOnClickListener {
            checkEmail()
        }
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