package com.flexcode.dscassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.activity_create_account.etEmail
import kotlinx.android.synthetic.main.activity_create_account.etPassword
import kotlinx.android.synthetic.main.activity_login.*

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

        //Validating user input on click of the signUp btn
       btnSignUp.setOnClickListener { validateUserDetails() }


    }

    //function to validate user details
    private fun validateUserDetails() {
        val firstName = etFirstName.text.toString().trim()
        val lastName = etLastName.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val confirmPassword = etConfirmPassword.text.toString().trim()

        if (TextUtils.isEmpty(firstName)){
            etFirstName.error = getString(R.string.error)
            return
        }
        if (TextUtils.isEmpty(lastName)){
            etLastName.error = getString(R.string.error)
            return
        }
        if (TextUtils.isEmpty(email)){
            etEmail.error = getString(R.string.email_1)
            return
        }
        if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches() ){
            return
        } else {
            etEmail.error = getString(R.string.invalid)
        }
        if (TextUtils.isEmpty(password)){
            etPassword.error = getString(R.string.pass)
            return
        }
        if (confirmPassword.isEmpty()){
            Toast.makeText(this@CreateAccount,
                    getString(R.string.pass2),
                    Toast.LENGTH_SHORT).show()
            if (confirmPassword != password){
                etConfirmPassword.error = getString(R.string.pass3)
            }
            return
        }
    }
}