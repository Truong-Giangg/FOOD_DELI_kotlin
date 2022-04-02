package com.first_java_app.k_login_signup.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.first_java_app.k_login_signup.R

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
//        val edt=findViewById<TextView>(R.id.profileEdt)
//        edt.setOnClickListener(){
//            openDialog()
//        }
    }

//    fun openDialog(){
//       Mydialog().show(supportFragmentManager,"mydialog")
//    }
}