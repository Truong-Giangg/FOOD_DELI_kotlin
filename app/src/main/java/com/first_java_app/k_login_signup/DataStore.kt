package com.first_java_app.k_login_signup

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore


class DataStore (val context: Context) {
    val Context.dataUser : DataStore<Preferences> by preferencesDataStore("user_prefs")

    companion object{
        var USER_NAME_KEY = toString()
        var USER_EMAIL_KEY = toString()
        var USER_PASS_KEY = toString()
        var USER_PHONE_KEY = toString()

    }

    suspend fun changedataUser(name: String, email: String, pass: String){
        context.dataUser.edit {
            USER_NAME_KEY = name
            USER_EMAIL_KEY = email
            USER_PASS_KEY = pass
            USER_PHONE_KEY = "(+84) 432 4233"
        }
    }
}