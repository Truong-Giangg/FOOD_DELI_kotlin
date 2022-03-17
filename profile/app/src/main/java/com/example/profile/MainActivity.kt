package com.example.profile

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        val edt=findViewById<TextView>(R.id.profileEdt)
        edt.setOnClickListener(){
            openDialog()
        }
    }

    fun openDialog(){
       Mydialog().show(supportFragmentManager,"mydialog")
    }
}