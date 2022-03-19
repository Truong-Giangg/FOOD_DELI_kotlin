package com.first_java_app.k_login_signup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val edt=findViewById<TextView>(R.id.editProfileClickable)
        edt.setOnClickListener(){
            openDialog()

        }
    }
    fun openDialog(){
        Mydialog().show(supportFragmentManager,"mydialog")
    }
}
