package com.first_java_app.k_login_signup.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.first_java_app.k_login_signup.R

class OnboardingActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding1)
        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener{
            val intent = Intent(this, OnboardingActivity2::class.java)
            startActivity(intent)
            finish()
        }

    }
}