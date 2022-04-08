package com.first_java_app.k_login_signup.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.first_java_app.k_login_signup.Constants.Constants
import com.first_java_app.k_login_signup.DataStore
import com.first_java_app.k_login_signup.R
import com.first_java_app.k_login_signup.activity.MenuListActivity
import com.first_java_app.k_login_signup.databinding.FragmentSignUpBinding
import com.first_java_app.k_login_signup.databinding.FragmentWelcomeBinding
import com.first_java_app.k_login_signup.model.User
import com.first_java_app.k_login_signup.viewmodel.UserLoginViewModel


class SignUpFragment : Fragment() {
    lateinit var binding:FragmentSignUpBinding
    lateinit var viewModel: UserLoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserLoginViewModel::class.java)
        listenerSuccessEvent()
        listenerErrorEvent()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtn.setOnClickListener {

            viewModel.checkEmailAndPassword(binding.inputEmail.text.toString().trim(),binding.inputPass.text.toString().trim())



        }
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) {
            if (it) {
                val controller = findNavController()
                controller.navigate(R.id.action_signUpFragment_to_menuFragment)
                var full_n= viewModel.user.fullName
                val email = binding.inputEmail.text.toString().trim()
                val password = binding.inputPass.text.toString().trim()
                // var fullName = viewModel.user.fullName
                val user = full_n?.let { it1 -> User(it1,email, password) }
                val intent = Intent(context, MenuListActivity::class.java)
                val bundle = Bundle()
                bundle.putParcelable(Constants.KEY_USER, user)

            }
        }
    }

    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(this) {
            val dialog = AlertDialog.Builder(requireContext())
            dialog.setTitle("Error")
            dialog.setMessage(it)
            dialog.show()
            // Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }




}