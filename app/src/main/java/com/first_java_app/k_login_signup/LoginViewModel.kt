package com.first_java_app.k_login_signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
enum class Error{
    ERROR_EMAIL,
    ERROR_PASSWORD,
}

//class Resp (var isSuccess :Boolean, var error:Error?)
class LoginViewModel: ViewModel() {
    private var _isSuccessEvent:MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessEvent :LiveData<Boolean>
    get()= _isSuccessEvent

    private var _isErrorEvent:MutableLiveData<String> = MutableLiveData()
    val isErrorEvent :LiveData<String>
        get()= _isErrorEvent

    fun checkEmailAndPassword (email:String,password:String){
        val isvalidemail= isValidEmail(email)
        val isvalidpassword= isValidPassword(password)
        if(!isvalidemail){
            _isErrorEvent.postValue("Email không hợp lệ!")
            return
        }
        if(!isvalidpassword){
            _isErrorEvent.postValue("Password không hợp lệ!")
            return
        }
        return _isSuccessEvent.postValue(true)
    }

    private fun isValidEmail(email: String):Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String):Boolean{
        return password.length in 6..10
    }
}