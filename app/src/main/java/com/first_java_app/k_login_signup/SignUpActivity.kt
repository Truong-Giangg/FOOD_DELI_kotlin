package com.first_java_app.k_login_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import com.first_java_app.k_login_signup.databinding.ActivitySignUpBinding
import java.util.regex.Pattern


class SignUpActivity : AppCompatActivity() {


    private lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_sign_up)


        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        emailFocusListener()
        passFocusListener()
        val gotoLogin = findViewById<TextView>(R.id.gotoLogin)
        gotoLogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun emailFocusListener() {
        binding.inputEmail.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.emailContainer.helperText=validEmail()
            }
        }
    }
    private fun passFocusListener() {
        binding.inputPass.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.passContainer.helperText=validPass()
            }
        }
    }

    private fun validPass(): String? {
        val passText=binding.inputPass.text.toString()
        val regex = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=\\S+$).{8,}$")
        if(!regex.matcher(passText).matches()){
            return "Mat khau bao gom chu hoa,chu thuong va ky tu dac biet"
        }
        return null
    }

    private fun validEmail(): String? {
        val mailText=binding.inputEmail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(mailText).matches()){
            return "Invalid Email"
        }
        return null
    }
}