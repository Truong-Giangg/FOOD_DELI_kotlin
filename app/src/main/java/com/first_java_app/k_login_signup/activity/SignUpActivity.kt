package com.first_java_app.k_login_signup.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.first_java_app.k_login_signup.DataStore
import com.first_java_app.k_login_signup.R
import com.first_java_app.k_login_signup.databinding.ActivitySignUpBinding
import com.first_java_app.k_login_signup.viewmodel.UserLoginViewModel


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    private lateinit var viewModel: UserLoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModel = ViewModelProvider(this).get(UserLoginViewModel::class.java)

        binding.gotoLogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener {
            val email = binding.inputEmail.text.toString().trim()
            val password = binding.inputPass.text.toString().trim()
            viewModel.checkEmailAndPassword(email,password)
        }
        listenerSuccessEvent()
        listenerErrorEvent()

    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) {
            if (it) {
                var fullname= binding.inputFullName.text.toString().trim()
                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                DataStore(fullname,
                    binding.inputEmail.text.toString().trim(),
                    binding.inputPass.text.toString().trim())
                intent.putExtra("fullname",fullname)
                Toast.makeText(applicationContext, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }
    }

    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(this) { errMess ->
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Error")
            dialog.setMessage(errMess)
            dialog.show()
        }
    }
}