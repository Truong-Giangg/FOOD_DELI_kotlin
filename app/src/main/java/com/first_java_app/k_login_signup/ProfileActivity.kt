package com.first_java_app.k_login_signup

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class ProfileActivity : AppCompatActivity(){
    lateinit var txtName:TextView
    lateinit var txtMail:TextView
    lateinit var txtPhone:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val edt=findViewById<TextView>(R.id.editProfileClickable)

        edt.setOnClickListener(){
            openDialog()

        txtName=findViewById<TextView>(R.id.txtName)
        txtMail=findViewById<TextView>(R.id.txtMail)
        txtPhone=findViewById<TextView>(R.id.txtPhone)
        edt.setOnClickListener(){
            openDialog()
        }
    }

    fun openDialog(){
        //Mydialog().show(supportFragmentManager,"mydialog")

        val mDialogView= LayoutInflater.from(this).inflate(R.layout.layout_dialog,null)
        val edtName=mDialogView.findViewById<EditText>(R.id.edtName)
        val edtMail=mDialogView.findViewById<EditText>(R.id.edtMail)
        val edtPhone=mDialogView.findViewById<EditText>(R.id.edtPhone)
        val mBuilder=AlertDialog.Builder(this)
            .setView(mDialogView)
            .setPositiveButton("Summit", DialogInterface.OnClickListener({ dialog, id->
                txtName.text=edtName.text
                txtMail.text=edtMail.text
                txtPhone.text=edtPhone.text
            }))
        mBuilder.show()



        }
    }
    fun openDialog(){
        Mydialog().show(supportFragmentManager,"mydialog")
    }
}
