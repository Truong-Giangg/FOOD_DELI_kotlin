package com.first_java_app.k_login_signup.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.first_java_app.k_login_signup.R
import com.first_java_app.k_login_signup.fragment.welcomeFragment

class OnboardingActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding2)
        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener{
            val intent = Intent(this, welcomeFragment::class.java)
            startActivity(intent)
            finish()
        }

    }
}