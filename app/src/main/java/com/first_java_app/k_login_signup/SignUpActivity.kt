package com.first_java_app.k_login_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.first_java_app.k_login_signup.databinding.ActivitySignUpBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: SignUpViewModel
    private lateinit var userManager: DataStore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModel= ViewModelProvider(this).get(SignUpViewModel::class.java)
        userManager = DataStore(this)
        binding.gotoLogin.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener{
            val email = binding.signupEmail.text.toString().trim()
            val password = binding.signupPass.text.toString().trim()
            viewModel.checkEmailAndPassword(email, password)
        }
        listenerSuccessEvent()
        listenerErrorEvent()
    }
    private fun listenerSuccessEvent(){
        viewModel.isSuccessEvent.observe(this){ isSuccess->
            if(isSuccess){
                val intent=Intent(this, LoginActivity::class.java)
                CoroutineScope(Dispatchers.IO).launch {
                    userManager.changedataUser(
                        binding.signupName.text.toString().trim(),
                        binding.signupEmail.text.toString().trim(),
                        binding.signupPass.text.toString().trim()
                    )
                }
                startActivity(intent)
            }
        }
    }
    private fun listenerErrorEvent(){
        viewModel.isErrorEvent.observe(this){errMsg ->
            Toast.makeText( this,errMsg, Toast.LENGTH_SHORT).show()
        }
    }
}