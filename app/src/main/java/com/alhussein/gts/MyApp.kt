package com.alhussein.gts

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }


    fun saveDarkMode(dark_mode: Boolean) {
        val mSharedPreferences = getSharedPreferences("dark_mode", MODE_PRIVATE)
        val editor = mSharedPreferences.edit()
        editor.putBoolean("dark_mode", dark_mode)
        editor.commit()
    }

    fun isDarkMode(): Boolean {
        val mSharedPreferences = getSharedPreferences("dark_mode", MODE_PRIVATE)
            ?: return true
        return mSharedPreferences.getBoolean("dark_mode", true)
    }

    fun saveLanguage(dark_mode: Boolean) {
        val mSharedPreferences = getSharedPreferences("language", MODE_PRIVATE)
        val editor = mSharedPreferences.edit()
        editor.putBoolean("lang", dark_mode)
        editor.commit()
    }

    fun getLanguage(): Int {
        val mSharedPreferences = getSharedPreferences("language", MODE_PRIVATE)
            ?: return 0
        return mSharedPreferences.getInt("lang", 0)
    }

}