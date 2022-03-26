package com.first_java_app.k_login_signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel: ViewModel() {
    private var _isSuccessEvent:MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessEvent :LiveData<Boolean>
        get()= _isSuccessEvent

    private var _isErrorEvent:MutableLiveData<String> = MutableLiveData()
    val isErrorEvent :LiveData<String>
        get()= _isErrorEvent
    fun checkEmail(email: String) {
        val isValidEmail = isEmailValid(email)
        if (!isValidEmail) {
            _isErrorEvent.postValue("Email không hợp lệ!")
            return
        }
        _isSuccessEvent.postValue(true)
    }
    fun checkEmailAndPassword (email:String,phoneNumber:String){
        val isValidEmail = isEmailValid(email)
        val isValidPhoneNumber= isPhoneNumberValid(phoneNumber)
        if(!isValidEmail){
            _isErrorEvent.postValue("Password không hợp lệ!")
            return
        }
        if(!isValidPhoneNumber){
            _isErrorEvent.postValue("Phone number không hợp lệ!")
            return
        }
        return _isSuccessEvent.postValue(true)
    }

    private fun isEmailValid(email: String):Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPhoneNumberValid(phoneNumber: String):Boolean{
        return phoneNumber.toInt() in 100000000..9999999999
    }
}