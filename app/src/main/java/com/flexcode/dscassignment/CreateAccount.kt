package com.flexcode.dscassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        //Intent to login page
        tvLogin.setOnClickListener {
            val intent =  Intent(this@CreateAccount, LoginActivity::class.java)
            startActivity(intent)
            onBackPressed()
        }
        //intent back to login page
        ivBack.setOnClickListener {
            val intent = Intent(this@CreateAccount,LoginActivity::class.java)
            startActivity(intent)
            onBackPressed()
        }

        //Validating user input on click of the signup btn
        btnSignUp.setOnClickListener(View.OnClickListener {
            val firstName = etFirstName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            if (TextUtils.isEmpty(firstName)){
                etFirstName.error = "Please enter your name!"
            }
            if (TextUtils.isEmpty(lastName)){
                etLastName.error = "Please enter your name!"
            }
            if (TextUtils.isEmpty(email)){
                etEmail.error = "Email cannot be blank!"
            }
            if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches() ){
                return@OnClickListener
            } else {
                Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show()
            }
            if (TextUtils.isEmpty(password)){
                etPassword.error = "Please enter your password"

            }
            if (confirmPassword.isEmpty()){
                Toast.makeText(this@CreateAccount,
                    "Please Confirm Your Password",
                    Toast.LENGTH_SHORT).show()
                if (confirmPassword != password){
                    etConfirmPassword.error = "Please check your password"
                }
            }
        })
    }
}