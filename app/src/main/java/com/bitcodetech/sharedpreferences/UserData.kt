package com.bitcodetech.sharedpreferences

import android.app.Activity
import android.content.Context

object UserData {

    private val USER_PREF_NAME = "user_preferences"
    private val KEY_TOKEN = "token"

    fun storeToken(context: Context, token : String) : Boolean{
        context.getSharedPreferences(USER_PREF_NAME, Activity.MODE_PRIVATE)
            .edit()
            .putString(KEY_TOKEN, token)
            .commit()

        return true
    }

    fun getToken(context: Context) : String? {
        return context.getSharedPreferences(USER_PREF_NAME, Activity.MODE_PRIVATE)
            .getString(KEY_TOKEN, null)
    }

}