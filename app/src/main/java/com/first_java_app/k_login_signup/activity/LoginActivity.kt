package com.first_java_app.k_login_signup.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.first_java_app.k_login_signup.Constants.Constants
import com.first_java_app.k_login_signup.DataStore
import com.first_java_app.k_login_signup.R
import com.first_java_app.k_login_signup.databinding.ActivityLoginBinding
import com.first_java_app.k_login_signup.model.User
import com.first_java_app.k_login_signup.viewmodel.UserLoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: UserLoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(UserLoginViewModel::class.java)


        binding.gotoSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        viewModel.user = DataStore("", "", "")
        binding.loginBtn.setOnClickListener {
            viewModel.checkEmailAndPassword(binding.inputEmail.text.toString().trim(),binding.inputPass.text.toString().trim())
        }
        listenerSuccessEvent()
        listenerErrorEvent()



    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) {
            if (it) {
                var full_n= viewModel.user.fullName
                val email = binding.inputEmail.text.toString().trim()
                val password = binding.inputPass.text.toString().trim()
               // var fullName = viewModel.user.fullName
                val user = full_n?.let { it1 -> User(it1,email, password) }
                val intent = Intent(applicationContext, MenuListActivity::class.java)
                val bundle = Bundle()
                bundle.putParcelable(Constants.KEY_USER, user)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(this) {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Error")
            dialog.setMessage(it)
            dialog.show()
            // Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

}