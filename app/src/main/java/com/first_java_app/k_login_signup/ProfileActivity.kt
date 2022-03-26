package com.first_java_app.k_login_signup

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.first_java_app.k_login_signup.databinding.ActivityProfileBinding
import com.google.android.material.textfield.TextInputLayout

class ProfileActivity : AppCompatActivity(){
    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: ProfileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        binding.user = UserHelper(DataStore.USER_NAME_KEY, DataStore.USER_EMAIL_KEY, DataStore.USER_PHONE_KEY)
        binding.editProfileClickable.setOnClickListener(){
            openDialog()
        }
        binding.txtName.setOnClickListener(){
            openDialog()
        }
        binding.txtMail.setOnClickListener(){
            openDialog()
        }
        binding.txtPhone.setOnClickListener(){
            openDialog()
        }
    }
    fun openDialog(){
        val mDialogView= LayoutInflater.from(this).inflate(R.layout.layout_dialog,null)
        val edtName=mDialogView.findViewById<EditText>(R.id.edtName)
        val edtMail=mDialogView.findViewById<EditText>(R.id.edtMail)
        val edtPhone=mDialogView.findViewById<EditText>(R.id.edtPhone)
        val mBuilder=AlertDialog.Builder(this)
            .setView(mDialogView)
            .setPositiveButton("Summit", DialogInterface.OnClickListener({ dialog, id->
                viewModel.checkEmail(edtMail.text.toString())
                listenerSuccessEvent(edtName.text.toString(),
                    edtMail.text.toString(),
                    edtPhone.text.toString()
                )
                listenerErrorEvent()
//                binding.txtName.text=edtName.text
//                binding.txtMail.text=edtMail.text
//                binding.txtPhone.text=edtPhone.text
            }))
        mBuilder.show()
    }
    private fun listenerSuccessEvent(name: String, email:String, phone:String) {
        viewModel.isSuccessEvent.observe(this) { isSuccess ->
            if (isSuccess) {
                binding.user = UserHelper(name, email, phone)
            }
        }
        DataStore.USER_EMAIL_KEY = email
        DataStore.USER_NAME_KEY = name
        DataStore.USER_PHONE_KEY = phone

    }
    private fun listenerErrorEvent(){
        viewModel.isErrorEvent.observe(this){
            Toast.makeText(this,it, Toast.LENGTH_SHORT).show()
        }
    }
}
