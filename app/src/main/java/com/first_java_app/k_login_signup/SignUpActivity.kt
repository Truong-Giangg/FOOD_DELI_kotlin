package com.first_java_app.k_login_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.first_java_app.k_login_signup.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.gotoLogin.setOnClickListener{
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPass.text.toString().trim()
            val intent = Intent(this, LoginActivity::class.java)
//            val bundle = Bundle()
//            bundle.putParcelable(Constants.KEY_USER, Student(email, password))
//            intent.putExtra(bundle)
            startActivity(intent)
        }
    }
}