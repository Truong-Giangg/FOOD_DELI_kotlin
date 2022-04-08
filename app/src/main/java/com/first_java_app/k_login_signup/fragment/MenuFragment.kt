package com.first_java_app.k_login_signup.fragment

import android.app.ActionBar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.first_java_app.k_login_signup.R
import com.first_java_app.k_login_signup.adapter.RestaurantAdapter
import com.first_java_app.k_login_signup.databinding.FragmentMenuBinding
import com.first_java_app.k_login_signup.viewmodel.MenuListViewModel
import com.first_java_app.k_login_signup.viewmodel.UserLoginViewModel
import java.util.zip.Inflater


class MenuFragment : Fragment() {

    lateinit var binding: FragmentMenuBinding
    lateinit var viewModel: MenuListViewModel
    lateinit var adapter: RestaurantAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater,container,false);

        return binding.root
    }

    private fun ActionToolBar() {

    }



    override fun onStart() {
        super.onStart()
    }





}