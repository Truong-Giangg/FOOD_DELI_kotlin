package com.example.profile

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class Mydialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder= AlertDialog.Builder(it)
            builder.setView(requireActivity().layoutInflater.inflate(R.layout.layout_dialog,null))
            builder.setPositiveButton("Summit", DialogInterface.OnClickListener({ dialog, id->

            }))
            builder.create()
        }?:throw IllegalStateException("Activity is Null!!")
    }
}