package com.first_java_app.k_login_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.first_java_app.k_login_signup.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.gotoSignup.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.loginBtn.setOnClickListener{
            val userNameVal = binding.inputEmail.editText?.text?.trim().toString()
            val passwordVal = binding.inputPass.editText?.text?.trim().toString()
//            if(userNameVal.equals("ronaldo@gmail.com")){
//                if(passwordVal.equals("123456")){
//                    val intent = Intent(this, ProfileActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                }else Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show()
//            }else Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show()

        }
    }

}