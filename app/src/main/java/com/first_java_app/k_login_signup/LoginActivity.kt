package com.first_java_app.k_login_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.first_java_app.k_login_signup.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.gotoSignup.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.loginBtn.setOnClickListener{
            val userNameVal = binding.inputEmail.editText?.text?.trim().toString()
            val passwordVal = binding.inputPass.editText?.text?.trim().toString()
            viewModel.checkEmailAndPassword(userNameVal,passwordVal)
//            if(userNameVal.equals("ronaldo@gmail.com")){
//                if(passwordVal.equals("123456")){
//                    val intent = Intent(this, ProfileActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                }else Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show()
//            }else Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show()

        }
        listenerErrorEvent()
        listenerSuccessEvent()
    }
    private fun listenerSuccessEvent(){
        viewModel.isSuccessEvent.observe(this){ isSuccess ->
            if(isSuccess){
                if(check()) {
                    Toast.makeText(this, "Đăng nhập thành công!!", Toast.LENGTH_SHORT).show()
                    val intent: Intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "Sai email hoặc password!!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun check(): Boolean {
        val userNameVal = binding.inputEmail.editText?.text?.trim().toString()
        val passwordVal = binding.inputPass.editText?.text?.trim().toString()
        val userNameVal1 = DataStore.USER_EMAIL_KEY
        val passwordVal1 = DataStore.USER_PASS_KEY
        if (userNameVal.equals(userNameVal1) && passwordVal.equals(passwordVal1)) return true
        return false
    }
    private fun listenerErrorEvent(){
        viewModel.isErrorEvent.observe(this){ errMsg ->
            Toast.makeText(this,errMsg,Toast.LENGTH_SHORT).show()
        }
    }
}