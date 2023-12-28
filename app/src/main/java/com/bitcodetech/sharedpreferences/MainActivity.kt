package com.bitcodetech.sharedpreferences

import android.app.Activity
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref : SharedPreferences =
            getSharedPreferences("my_prefs", Activity.MODE_PRIVATE)

        val editor = pref.edit()
        editor.putString("name", "Vishal")
        editor.putInt("code", 1234)
        editor.commit()

        val name = pref.getString("name", "NA")
        val code = pref.getInt("code", -1)

        mt("$name $code")

        UserData.storeToken(this, "ADET456@#DFE90")
        mt(UserData.getToken(this)!!)

        val pref1 = getPreferences(Activity.MODE_PRIVATE)
        pref1.edit()
            .putString("some_data", "Sample data")
            .commit()

        mt(pref1.getString("some_data", "Not Available")!!)
    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}