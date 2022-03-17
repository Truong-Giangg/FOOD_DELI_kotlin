package com.first_java_app.k_login_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val userName = findViewById<TextInputLayout>(R.id.inputEmail)
        val password = findViewById<TextInputLayout>(R.id.inputPass)

        val gotoSignup = findViewById<TextView>(R.id.gotoSignup)
        gotoSignup.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        val loginButton = findViewById<Button>(R.id.loginBtn)
        loginButton.setOnClickListener{
            val userNameVal = userName.editText?.text?.trim().toString()
            val passwordVal = password.editText?.text?.trim().toString()
            if(userNameVal.equals("ronaldo@gmail.com")){
                if(passwordVal.equals("123456")){
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    finish()
                }else print("wrong password")
            }else print("wrong username!!")

//            val intent = Intent(this, SignUpActivity::class.java)
//            startActivity(intent)
        }



    }

}